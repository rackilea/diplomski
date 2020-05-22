// Example with a one-shot delay
    ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    executor.schedule(clearstage(), 5, TimeUnit.SECONDS);
    executor.shutdown();
    executor.awaitTermination(6, TimeUnit.SECONDS);
    System.out.println("Done.");


    // And your clearstage() must be implemented like this:
    private static Runnable clearstage() {
      return new Runnable() {
        @Override
        public void run() {
            // Code goes here...
        }
      };
    }