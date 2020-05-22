// Create the ScheduledExecutorService
ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
// Submit the task to be executed in 200 milliseconds
ScheduledFuture<?> future = executor.schedule(new Runnable() {
    @Override
    public void run() {
        // Launch my query here
    }
}, 200, TimeUnit.MILLISECONDS);