// Declare your pool. Declare ThreadFactory also, it will be very
// helpful with debug, I promise :) 
int corePoolSize = 10;
ScheduledExecutorService pool = Executors.newScheduledThreadPool(corePoolSize,
      new ThreadFactoryBuilder().setNameFormat("Your-thread-%d").setDaemon(true).build());

List<CompletableFuture<Void>> dependencies = new ArrayList<>();

// Submit the threads for the first stage
dependencies.add(CompletableFuture.runAsync(new AllarmReasonService(), pool));
dependencies.add(CompletableFuture.runAsync(new ManufactureReasonService(), pool));
// ...
// do the same with all your stage-1 threads

// wait while stage 1 completed
try {
    for (CompletableFuture<Void> f : dependencies) {
        f.get();
    }
} catch (InterruptedException | ExecutionException e) {
    // log or re-throw
    pool.shutdownNow();
}

// stage 2
CompletableFuture.runAsync(new AllarmReasonService(), pool);
CompletableFuture.runAsync(new ManufactureReasonService(), pool);
// other required ...