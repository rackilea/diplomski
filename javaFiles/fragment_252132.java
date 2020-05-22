// Main thread
private Handler handler = new Handler() {
  public void handleMessage(Message msg) {
    Log.d(TAG, "dealing with message: " + msg.what);
  }
};

  ...

// Some other thread
Message msg = handler.obtainMessage(what);
handler.sendMessage(msg);