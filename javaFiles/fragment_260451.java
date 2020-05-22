public static void main(String args[]) throws Exception {
    CompletableFuture<String> root = new CompletableFuture<>();

    ExecutorService executor = Executors.newSingleThreadExecutor();
    executor.submit(() -> {
        CompletableFuture<String> cf1 = CompletableFuture.completedFuture("first");
        CompletableFuture<String> cf2 = CompletableFuture.completedFuture("second");

        System.out.println("running");
        CompletableFuture.allOf(cf1, cf2).thenRun(() -> root.complete("some value"));
    });

    // once the internal 10 have completed (successfully)
    root.thenAccept(r -> {
        System.out.println(r); // "some value"
    });

    Thread.sleep(100);
    executor.shutdown();
}