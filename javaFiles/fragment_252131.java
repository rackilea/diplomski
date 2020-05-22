// Main thread
private Handler handler = new Handler();

  ...

// Some other thread
handler.post(new Runnable() {
  public void run() {
    Log.d(TAG, "this is being run in the main thread");
  }
});