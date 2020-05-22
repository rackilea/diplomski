private void validateMicAvailability() throws MicUnaccessibleException {
    AudioRecord recorder =
        new AudioRecord(AudioSource.MIC, 44100,
                AudioFormat.CHANNEL_IN_MONO,
                AudioFormat.ENCODING_DEFAULT, 44100);
    try{
        if(recorder.getRecordingState() != AudioRecord.RECORDSTATE_STOPPED ){
            throw new MicUnaccessibleException("Mic didn't successfully initialized");
        }

        recorder.startRecording();
        if(recorder.getRecordingState() != AudioRecord.RECORDSTATE_RECORDING){
            recorder.stop();
            throw new MicUnaccessibleException("Mic is in use and can't be accessed");
        }
        recorder.stop();
    } finally{
        recorder.release();
        recorder = null;
    }
}