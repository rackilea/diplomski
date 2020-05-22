ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
ScheduledFuture<String> scheduledFuture = scheduledExecutorService.schedule(new Callable<String>() {
    @Override
    public String call() throws Exception {
        return "Result";
    }
}, 5, TimeUnit.SECONDS);