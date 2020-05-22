ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
Runnable tickTask = () -> System.out.println("Tick");
ScheduledFuture<?> scheduledTickTask = executor.scheduleAtFixedRate(tickTask, 0, 1, TimeUnit.SECONDS);
Runnable cancelTask = () -> {
    scheduledTickTask.cancel(true);
    executor.shutdown();
};
executor.schedule(cancelTask, 5, TimeUnit.SECONDS);
executor.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);