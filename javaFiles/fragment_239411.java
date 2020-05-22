ScheduledFuture<String> task = executorService.schedule(new Callable<String>() {
  @Override
  public String call() {
    cacheNames.remove("unique_string");
    return "unique_string";
  }
}, 1, TimeUnit.SECONDS);
cacheNames.put("unique_string", task);