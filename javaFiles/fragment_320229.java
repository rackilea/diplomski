ScheduledFuture<?> future = scheduledExecutorService.scheduleAtFixedRate(new ThreadToDie(), 0,5, TimeUnit.SECONDS);
try {
   future.get();
} catch (ExecutionException ex) {
   ex.getCause().printStackTrace();
}