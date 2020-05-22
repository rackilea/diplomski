public static void main(String[] args) throws InterruptedException {
    ExecutorService executor = Executors.newFixedThreadPool(1);
    executor.submit(new Runnable() {

        @Override
        public void run() {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("interrupted");
                    break;
                }
            }
        }
    });

    executor.shutdown();
    if (!executor.awaitTermination(100, TimeUnit.MICROSECONDS)) {
        System.out.println("Still waiting after 100ms: calling System.exit(0)...");
        System.exit(0);
    }
    System.out.println("Exiting normally...");
}