List<Future<?>> futures = new ArrayList<Future<?>>();
for (int executorCount = 0; executorCount < 10000; ++executorCount) {
    futures.add(executor.submit(r));
}
executor.shutdown();
executor.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
for (Future<?> future : futures) {
    // this will throw an exception if an assert happened
    future.get();
}