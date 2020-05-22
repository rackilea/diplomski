// Some other thread
runOnUiThread(new Runnable() {      // Only available in Activity
  public void run() {
    // perform action in ui thread
  }
});