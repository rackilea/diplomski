ExecutorService executor = Executors.newFixedThreadPool(10);
for(Runnable oneRecordRunnable : allRunnables) {
    executor.submit(oneRecordRunnable);
}
executor.shutdown();
executor.awaitTermination(1, TimeUnit.HOURS);