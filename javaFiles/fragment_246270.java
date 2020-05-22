public void run() {
  while (!Thread.getCurrentThread().isInterrupted()) {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      // Nothing here
    }
  }
}