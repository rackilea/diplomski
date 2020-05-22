public class AudioActivity extends Activity {
AudioTrack audio = new AudioTrack(AudioManager.STREAM_MUSIC,
        44100,
        AudioFormat.CHANNEL_OUT_STEREO,
        AudioFormat.ENCODING_PCM_16BIT,
        intSize, //size of pcm file to read in bytes
        AudioTrack.MODE_STATIC);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //read track from file
        File file = new File(getFilesDir(), fileName);

        int size = (int) file.length();
        byte[] data = new byte[size];

        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(data, 0, size);
            fileInputStream.close();

            audio.write(data, 0, data.length);
        } catch (IOException e) {}
    }

    //change playback speed by factor
    void changeSpeed(double factor) {
        audio.setPlaybackRate((int) (audio.getPlaybackRate() * factor));
    }
}