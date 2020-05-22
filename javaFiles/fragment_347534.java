ScheduledExecutorService executor = Executors.newScheduledThreadPool(1, new ThreadFactory() {
  public Thread newThread(Runnable r) {
    final Thread result = new Thread(r);
    result.setPriority(Thread.MAX_PRIORITY);
    return result;
  }
});

executor.scheduleAtFixedRate(new TotallyImportantTask(), 0, 10, TimeUnit.SECONDS);