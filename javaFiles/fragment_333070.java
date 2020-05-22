ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

    Runnable runnable= new Runnable() {
        public void run() {
            myUitoBeModified.access(() -> someStuff());
        }
    };
    executor.scheduleAtFixedRate(runnable, 0, 10, TimeUnit.SECONDS);