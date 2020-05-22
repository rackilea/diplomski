ExecutorService threadPool = Executors.newFixedThreadPool(40);
// submit work
threadPool.shutdown();
try {
  threadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
} catch (InterruptedException e) {
  // do something
}