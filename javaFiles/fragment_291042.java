class audio {

AudioRecord arec;
AudioTrack atrack;
private volatile boolean isRecording= false;

private static int buffer_size;
//final short[] buffer = new short[buffersize];
//short[] readbuffer = new short[buffersize];


private int sample_rate;//the rate of recording used to initialise AudioRecord
private int[] msample_rates = new int[]{44100, 22050, 11025, 8000};

private short audio_format;
private short[] audio_formats = new short[]{AudioFormat.ENCODING_PCM_8BIT, AudioFormat.ENCODING_PCM_16BIT};

private short channel_config;
private short[] channel_configs = new short[]{AudioFormat.CHANNEL_IN_MONO, AudioFormat.CHANNEL_IN_STEREO};
private short channelOutConfig;

public AudioRecord findAudioRecord(){
    for (int rate_f : msample_rates){
        for (short audioformat_f : audio_formats){
            for (short channelconfig_f : channel_configs){

                try {
                    Log.i("AudioC", "Attempting rate : "+ rate_f + "Hz, bits: " + audioformat_f + ", Channel: " + channelconfig_f);
                    int buffersize_f = AudioRecord.getMinBufferSize(rate_f, channelconfig_f, audioformat_f);

                    Log.i("AudioC", "Buffersize: " + buffersize_f);
                    if (buffersize_f != AudioRecord.ERROR_BAD_VALUE){
                        //Check of we can instantiate and have a success
                        AudioRecord recorder = new AudioRecord(MediaRecorder.AudioSource.MIC, rate_f, channelconfig_f, audioformat_f, buffersize_f);

                        Log.i("AudioC", "Recorder State Value: " + recorder.getState());
                        if(recorder.getState() == AudioRecord.STATE_INITIALIZED){
                            Log.i("Audio", "Success");
                            //global values
                            buffer_size = buffersize_f;
                            sample_rate = rate_f;
                            audio_format = audioformat_f;
                            channel_config = channelconfig_f;

                            if (channelconfig_f == AudioFormat.CHANNEL_IN_MONO) channelOutConfig = AudioFormat.CHANNEL_OUT_MONO;
                            else channelOutConfig = AudioFormat.CHANNEL_OUT_STEREO;
                            return recorder;
                        }

                    }
                }catch (Exception e){
                    Log.i("AudioC", rate_f + " Exception, keep trying." + e);
                }
            }
        }
    }
    Log.i("AudioC", "Failed to initialise the audio record state");
    return null;

}

public void run(){

    isRecording = true;
    //initialization
    android.os.Process.setThreadPriority(Process.THREAD_PRIORITY_AUDIO);

    //getValidSampleRates();
   // int buffersize = AudioRecord.getMinBufferSize(sample_rate,AudioFormat.CHANNEL_IN_MONO,AudioFormat.ENCODING_PCM_16BIT);
   // arec = new AudioRecord(MediaRecorder.AudioSource.MIC,sample_rate, AudioFormat.CHANNEL_IN_MONO, AudioFormat.ENCODING_PCM_16BIT, buffersize);
    //The above lines were replaced by a looping function in order to test every occurrence of rate,audioformat and channelconfig which is usually different for different adroid devices
    arec = findAudioRecord();//Still failed to initialize the Audio Recorder


    atrack = new AudioTrack(AudioManager.STREAM_VOICE_CALL,
            sample_rate,
            channelOutConfig,
            audio_format,
            buffer_size,
            AudioTrack.MODE_STREAM);
    atrack.setPlaybackRate(sample_rate);
    //run
    byte[] buffer = new byte[buffer_size];
    arec.startRecording();
    atrack.play();

            while (isRecording){
                arec.read(buffer, 0, buffer_size);
                atrack.write(buffer, 0,buffer.length);
            }
            arec.release();
            atrack.release();
}


public void stop(){
    isRecording= false;
    arec.stop();
    atrack.stop();
    arec.release();
    atrack.release();
}