ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
// Schedule the main task to be executed every one our
service.scheduleAtFixedRate(
    new Runnable() {
        @Override
        public void run() {
            // Get the initial time
            long initial = System.currentTimeMillis();
            // Iterate as long as the current time - initial time is less than 60 K ms (1m)
            do {
                // Here is my recursive task that I want to do during 1 minute
            } while ((System.currentTimeMillis() - initial) < 60_000L);
        }
    }, 0L, 1L, TimeUnit.HOURS
);