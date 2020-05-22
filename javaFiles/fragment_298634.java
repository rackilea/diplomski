public static void main(String[] args) throws Exception {
    ExecutorService service = Executors.newFixedThreadPool(1);
    CompletableFuture<String> completable = new CompletableFuture<>();
    Future<?> future = service.submit(new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                if (Thread.interrupted()) {
                    return; // remains uncompleted
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    return; // remains uncompleted
                }
            }
            completable.complete("done");
        }
    });

    Thread.sleep(2000);

    // not atomic across the two
    boolean cancelled = future.cancel(true);
    if (cancelled)
        completable.cancel(true); // may not have been cancelled if execution has already completed
    if (completable.isCancelled()) {
        System.out.println("cancelled");
    } else if (completable.isCompletedExceptionally()) {
        System.out.println("exception");
    } else {
        System.out.println("success");
    }
    service.shutdown();
}