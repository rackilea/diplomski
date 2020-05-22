private TaskScheduler scheduler = new ConcurrentTaskScheduler();

@PostConstruct
private void executeJob() {
    scheduler.scheduleAtFixedRate(new Runnable() {
        @Override
        public void run() {
            // your business here
        }
    }, INTERVAL);
}