ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
executor.scheduleWithFixedDelay(() -> {
  Compute.ZoneOperations.Get get = 
  getCompute().zoneOperations().get(projectId, zone, operation.getName());
  operation = get.execute();

  if (operation != null && operation.getStatus().equals("DONE")) {
     executor.shutdown();
  }
}, 0, 5, TimeUnit.SECONDS);
//if you need to block current thread
executor.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);