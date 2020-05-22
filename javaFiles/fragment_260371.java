final ExecutorService producers = Executors.newFixedThreadPool(100);
final ExecutorService consumers = Executors.newFixedThreadPool(100);
while (/* has more work */) {
  producers.submit(...);
}
producers.shutdown();
producers.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
consumers.shutdown();
consumers.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);