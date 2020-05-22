private void stopRecording() {
  try {
      recorder.stop();
      recorder.release();
      recorder = null;
  } catch(Exception e) {}
}