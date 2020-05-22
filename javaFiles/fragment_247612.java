public static void main(String[] args) throws InterruptedException, ExecutionException {
    ScheduledExecutorService scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    SmartCardApi smartCardApi = new SmartCardApi();

    // Polling job.
    Runnable job = new Runnable() {
        @Override
        public void run() {
            System.out.println("Is card in slot? " + smartCardApi.isCardInSlot());
        }
    };

    // Schedule the check every second.
    scheduledExecutor.scheduleAtFixedRate(job, 1000, 1000, TimeUnit.MILLISECONDS);

    // After 3.5 seconds, insert the card using the API.
    Thread.sleep(3500);
    smartCardApi.insert(1);

    // After 4 seconds, eject the card using the API.
    Thread.sleep(4000);
    smartCardApi.eject();

    // Shutdown polling job.
    scheduledExecutor.shutdown();

    // Verify card status.
    System.out.println("Program is exiting. Is card still in slot? " + smartCardApi.isCardInSlot());
}