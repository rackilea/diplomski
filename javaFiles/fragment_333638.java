public void start() {

    System.out.println("Application Started. . .");

    taskScheduler.scheduleAtFixedRate(myRunnable, Date.from(Instant.now()),
            TimeUnit.DAYS.toMillis(1));

    while (true) {
        try {
            Thread.sleep(Long.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}