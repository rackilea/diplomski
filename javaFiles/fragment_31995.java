class LooperThread extends Thread {
  public Handler mHandler;

  public void run() {
      Looper.prepare();

      mHandler = new Handler() {
          public void handleMessage(Message msg) {

          }
      };

      Looper.loop();

  }
}