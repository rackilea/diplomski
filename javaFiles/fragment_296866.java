private final ScheduledExecutorService service = Executors.newSingleThreadExecutor();

  public static void testExecuteBomb(ExecutorService service) {
    service.execute(new Runnable() {
      @Override
      public void run() {
        printWithMillis("execute bombing...");
        if (true) throw new RuntimeException("Bomb");
      }
    });

    sleep();

    service.shutdownNow();
  }

  public static void testSubmitBomb(ExecutorService service) {
    try {
      Future t = service.submit(new Runnable() {
        @Override
        public void run() {
          printWithMillis("submit bombing...");
          if (true) throw new RuntimeException("Bomb");
        }
      });

      sleep();

      try {
        printWithMillis(String.valueOf(t.get()));
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    } finally {
      service.shutdownNow();
    }
  }