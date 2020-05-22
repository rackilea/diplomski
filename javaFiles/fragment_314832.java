Thread thread = ThreadManager.createBackgroundThread(new Runnable() {
  public void run() {
    try {
      while (true) {
        System.err.println("Doing something!");
        Thread.sleep(30_000);
      }
    } catch (InterruptedException ex) {
    }
  }
});
thread.start();