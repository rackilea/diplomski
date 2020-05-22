public static void getValidSampleRates() {
    int desiredRate = 0;
    for (int rate : new int[] {44100, 8000, 11025, 16000, 22050}) {
        int bufferSize = AudioRecord.getMinBufferSize(rate, AudioFormat.CHANNEL_IN_MONO, AudioFormat.ENCODING_PCM_16BIT);
        if (bufferSize > 0) {
            // buffer size is valid, Sample rate supported
            AudioRecord audioRecorder = new AudioRecord(AudioSource.MIC, rate, AudioFormat.CHANNEL_IN_MONO, AudioFormat.ENCODING_PCM_16BIT, bufferSize);

            if (audioRecorder.getState() != AudioRecord.STATE_INITIALIZED) {
                desiredRate = -1;
                audioRecorder.release();
            } else {
                desiredRate = rate;
                break;
            }
        }
    }
}