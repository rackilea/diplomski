CompletableFuture<Integer> f1 = CompletableFuture.supplyAsync(() -> {
    LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(1));
    throw new IllegalArgumentException("Error for testing");
});
CompletableFuture<Integer> f2 = f1.exceptionally(t -> 42);

report("f1", f1);
report("f2", f2);

ForkJoinPool.commonPool().awaitQuiescence(1, TimeUnit.DAYS);