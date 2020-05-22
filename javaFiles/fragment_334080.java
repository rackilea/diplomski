class MyLooper extends Thread {
  public Handler handler;

  public void run() {
      Looper.prepare();

      handler = new Handler() {
          public void handleMessage(Message msg) {}
      };

      Looper.loop();
  }
}