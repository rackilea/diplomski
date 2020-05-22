final ExecutorService executor = Executors.newFixedThreadPool(1);
executor.submit(new Runnable() {
  public void run() {
    try {
      Thread.sleep(20 * 1000);
    } catch (InterruptedException e) {
      System.out.println("Interrupted, so exiting.");
    }
  }
});

if (executor.awaitTermination(10, TimeUnit.SECONDS)) {
  System.out.println("task completed");
} else {
  System.out.println("Forcing shutdown...");
  executor.shutdownNow();
}