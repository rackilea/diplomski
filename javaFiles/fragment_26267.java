boolean isRecording = false;
private void startRecording() {
        recorder = new MediaRecorder();
        recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        recorder.setOutputFile(fileName);
        System.out.println(fileName);
        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

        try {
            recorder.prepare();
            recorder.start();
            isRecording = true;
        } catch (IOException e) {
            Log.e(LOG_TAG, "prepare() failed");
            //e.printStackTrace();
        }
}
....
private void stopRecording() {
    if(isRecording){
        recorder.stop();  
    }
    recorder.reset();   // You can reuse the object by going back to setAudioSource() step
    recorder.release(); // Now the object cannot be reused
    isRecording = false;
}