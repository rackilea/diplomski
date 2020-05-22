final ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
final Future<?> taskHandle = scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
    @Override
    public void run() {
        final ListenableFuture<Void> lf = doWorkAsync();
        try {
            doWorkAsync().get();
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        } catch (ExecutionException ex) {
            throw new RuntimeException(ex);
        }
    }
}, 0, WAIT_TIME_BETWEEN_CALLS_SECS, TimeUnit.SECONDS);
scheduledExecutorService.schedule(new Runnable() {
    @Override
    public void run() {
        taskHandle.cancel(false);
    }
}, TOTAL_TIME_SECS, TimeUnit.SECONDS);