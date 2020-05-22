static final ScheduledExecutorService SCHEDULER
  = Executors.newSingleThreadScheduledExecutor(r -> {
    Thread t = new Thread(r);
    t.setDaemon(true);
    return t;
  });