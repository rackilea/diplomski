ExecutorService taskExecutor = Executors.newFixedThreadPool(4);
while(...) {
  taskExecutor.execute(new MyTask());
}
taskExecutor.shutdown();
try {
  taskExecutor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
} catch (InterruptedException e) {
  ...
}