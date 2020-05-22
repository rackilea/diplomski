ScheduledExecutorService executor = Executors.newScheduledThreadPool(count);
ScheduledFuture<?> future = executor.scheduleWithFixedDelay(
                                   task, 
                                   delay, 
                                   delay, 
                                   TimeUnit.MILLISECONDS
                                  );