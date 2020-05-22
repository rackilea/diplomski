final ScheduledExecutorService pool = new ScheduledThreadPoolExecutor(100);
    Runnable control = new Runnable()
    {
      public void run() {
        Runnable task = new Runnable() {
          public void run() {
             // do work here
          }
        };
        pool.execute(task);
      };
    };
    pool.scheduleAtFixedRate(control, 5l, 1l, TimeUnit.SECONDS);