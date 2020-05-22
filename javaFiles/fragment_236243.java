new Thread(new Runnable() {
      @Override
      public void run() {
try {
    Thread.sleep(100L);
} catch (InterruptedException e) {
}
    //your background code.
      }
    }).start();