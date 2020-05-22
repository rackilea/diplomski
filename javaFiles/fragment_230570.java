private Runnable runInBackground = new Runnable() {
  private void run() {
    handler.post(runOnGUI);
    // Do processing
  }
};