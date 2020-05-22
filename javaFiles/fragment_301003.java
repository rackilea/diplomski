public static void main(String[] args) throws InterruptedException {
    ExecutorService pool = Executors.newFixedThreadPool(10, r -> {
        Thread t = new Thread(r);
        t.setDaemon(false); // must be not daemon
        return t;
    });

    for (int i = 0; i < 100; i++) {
        final int a = i;

        // the operation must be Async with our thread pool
        CompletableFuture<Boolean> cf = CompletableFuture.supplyAsync(() -> doPost(a), pool);
        cf.thenRun(() -> System.out.printf("%s: Run_%s%n", Thread.currentThread().getName(), a));
    }

    pool.shutdown(); // without this the main application will be blocked forever
}

private static boolean doPost(int t) {
    System.out.printf("%s: Post_%s%n", Thread.currentThread().getName(), t);

    return true;
}