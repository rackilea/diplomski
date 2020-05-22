ExecutorService executor = Executors.newFixedThreadPool(3);

executor.submit(runnable1);
executor.submit(runnable2);
executor.submit(runnable3);

executor.shutdown();
boolean allRunnableAreDone = executor.awaitTermination(60, TimeUnit.SECONDS);

// This line is reached once all runnables have finished their job
// or the 60 second timeout has expired