ScheduledFuture<Boolean> countdown = scheduler.schedule(new Callable<Boolean>() {
    public Boolean call() {
        return attemptRetrieval(...);
    }}, 1, TimeUnit.MINUTES);

return countdown.get();