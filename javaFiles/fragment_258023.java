public class RadioListener {
private Runnable mRunnable, mFounderR;
private Thread mThread = null, mFounderT = null;

private SourceDataLine mSourceLine;
private TargetDataLine mTargetLine;
private DataLine.Info mTargetInfo;
private DataLine.Info mSourceInfo;
private static final AudioFormat mFormat = new AudioFormat(44100, 16, 2, true, false);

private Mixer.Info[] mixers;
private Mixer mFoundMixer = null;

private Config mConfig;

private boolean isCommunicating = false;
private boolean isRetranslating = false;

private static final String mHeader = "header.wav";
//private File wavFile = null;
AudioFileFormat.Type fileType = AudioFileFormat.Type.WAVE;
AudioInputStream ais;
private FileOutputStream fos;
private boolean isRecording = false;

public RadioListener (Config cfg) {
    mConfig = cfg;

    mixers = AudioSystem.getMixerInfo();
    mSourceInfo = new DataLine.Info(SourceDataLine.class, mFormat);
    mTargetInfo = new DataLine.Info(TargetDataLine.class, mFormat);
    try {mSourceLine = (SourceDataLine) AudioSystem.getLine(mSourceInfo);}
    catch (LineUnavailableException e) {System.out.println("RadioListener output error");}

    //wavFile = new File("E:/RecordAudio.wav");
}

public void Start() {
    if (Defines.strToIntDef(mConfig.getProperty("debugOut"), 0) == 1)
        showMixers();

    if (mFoundMixer == null) searchDevice();
    else startCommunication();
}

public void Stop() {
    if (mFoundMixer == null) return;

    try {
        mSourceLine.stop();
        mSourceLine.close();

        mTargetLine.stop();
        mTargetLine.close();
    } catch (Exception e) {}
    finally {
        isCommunicating = false;
    }
}

public void disposeListener() {
    if (isRecording) stopRecording();

    Stop();

    if (mFounderT != null)
        if (mFounderT.isAlive())
            mFounderT.interrupt();

    if (mThread != null)
        if (mThread.isAlive())
            mThread.interrupt();
}

public void Mute() {
    isRetranslating = false;
}

public void enableRecording (boolean f) {
    if (f) startRecording();
    else stopRecording();
}

public boolean isRecording() {
    return isRecording;
}

private void startRecording() {
    final DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
    Date date = new Date(System.currentTimeMillis());
    String dt = formatter.format(date);
    final InputStream stream = this.getClass().getResourceAsStream("/" + mHeader);
    byte b[] = new byte[44];
    try {
        fos = new FileOutputStream(Defines.getCurrentFolder() + File.separator + dt + ".wav", true);
        try {
            stream.read(b, 0, 44);
            fos.write(b);
        } catch (IOException e) {
            try {fos.close();}
            catch (IOException e1) {;}
            isRecording = false;
            return;
        }

    } catch (FileNotFoundException e) {
        isRecording = false;
    }
    isRecording = true;
}

private void stopRecording() {
    isRecording = false;

    try {fos.close();}
    catch (IOException e) {;}
    isRecording = false;
}

private void searchDevice() {
    mFounderR = new RadioFinder();
    mFounderT = new Thread(mFounderR);
    mFounderT.start();
}

private void startThread() {
    startCommunication();
    mRunnable = new Communicator();
    mThread = new Thread(mRunnable);
    mThread.start();
}

private void startCommunication() {
    if (isCommunicating) {
        isRetranslating = true;
        return;
    }
    try {
        mTargetLine.open(mFormat);
        mTargetLine.start();

        mSourceLine.open(mFormat);
        mSourceLine.start();

        //Line line = mFoundMixer.getLine(mSourceInfo);
        //FloatControl control = (FloatControl)line.getControl(FloatControl.Type.MASTER_GAIN);
        //control.setValue(limit(control,10000));
        //control.setValue(-10);

        isCommunicating = true;
        isRetranslating = true;

        //ais = new AudioInputStream(mTargetLine); //ok
        //AudioSystem.write(ais, fileType, wavFile); //ok
    } catch (Exception e) {
        isCommunicating = false;
        isRetranslating = false;
    }
}

private class RadioFinder implements Runnable {
    @Override
    public void run() {
        Line.Info targetDLInfo = new Line.Info(TargetDataLine.class);
        for (Mixer.Info info : mixers) {
            Mixer tmp = AudioSystem.getMixer(info);
            //if (myMixer.isLineSupported(Port.Info.LINE_IN) || myMixer.isLineSupported(Port.Info.MICROPHONE)) {
            if (tmp.isLineSupported(targetDLInfo)) {
                String s = tmp.getMixerInfo().getName();
                if (s.toLowerCase().contains(mConfig.getProperty("radioName").toLowerCase())) {
                    mFoundMixer = tmp;
                    try {
                        mTargetInfo = new DataLine.Info(TargetDataLine.class, mFormat);
                        mTargetLine = (TargetDataLine) mFoundMixer.getLine(mTargetInfo);

                        System.out.println("Found radio device: " + mFoundMixer.getMixerInfo().getName());

                        startThread();
                    } catch (Exception e) {
                        System.out.println("RadioListener input error");
                        mFoundMixer = null;
                    }
                    break;
                }
            }
        }
    }
}

private static void showMixers() {
    ArrayList<Mixer.Info> mixInfos = new ArrayList<Mixer.Info>(Arrays.asList(AudioSystem.getMixerInfo()));

    Line.Info sourceDLInfo = new Line.Info(SourceDataLine.class);
    Line.Info targetDLInfo = new Line.Info(TargetDataLine.class);
    Line.Info clipInfo = new Line.Info(Clip.class);
    Line.Info portInfo = new Line.Info(Port.class);

    String support;

    for (Mixer.Info mixInfo: mixInfos) {
        Mixer mixer = AudioSystem.getMixer(mixInfo);

        support = ", supports ";
        if (mixer.isLineSupported(sourceDLInfo))
            support += "SourceDataLine ";
        if (mixer.isLineSupported(clipInfo))
            support += "Clip ";
        if (mixer.isLineSupported(targetDLInfo))
            support += "TargetDataLine ";
        if (mixer.isLineSupported(portInfo))
            support += "Port ";

        System.out.println("Mixer: " + mixInfo.getName() + support + ", " + mixInfo.getDescription());
    }
}

private class Communicator implements Runnable {
    @Override
    public void run() {
        int numBytesRead;
        byte[] targetData = new byte[mTargetLine.getBufferSize() / 5];

        while (isCommunicating) {
            numBytesRead = mTargetLine.read(targetData, 0, targetData.length);

            if (numBytesRead == -1) break;

            if (isRetranslating)
                mSourceLine.write(targetData, 0, numBytesRead);

            if (isRecording) {
                try {fos.write(targetData);}
                catch (IOException e) {stopRecording();}
            }
        }
    }
}

}