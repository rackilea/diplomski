private void startRecording() {
    recorder = new MediaRecorder();
    recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
    recorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
    recorder.setOutputFile(fileName);
    recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC);

    try {
        recorder.prepare();
    } catch (IOException e) {
        Log.e(LOG_TAG, "prepare() failed");
    }

    recorder.start();
    isStarted = true;
}

private void stopRecording() {
  if(isStarted) {
    recorder.stop();
    recorder.release();
    recorder = null;
    isStarted = false;
  }
}