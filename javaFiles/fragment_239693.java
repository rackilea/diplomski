new Thread() {
  public void run() {
    // do cool stuff
    runOnUiThread(new Runnable() {
      public void run() {
        // do other cool stuff quickly on the main application thread
      }
    );
  }
}).start();