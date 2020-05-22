// Cancel the task which will interrupt the thread that was executing the 
// task if any
future.cancel(true);
// Re-submit the task
future = executor.schedule(new Callable<Void>() {
    @Override
    public Void call() throws InterruptedException {
        ...
        // Check regularly in your code if the thread has been
        // interrupted and if so throws an exception to stop
        // the task immediately 
        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedException("Thread interrupted");
        }
        ...
    }
}, 200, TimeUnit.MILLISECONDS);