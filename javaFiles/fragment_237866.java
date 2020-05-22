CompletableFuture<?> f = CompletableFuture.supplyAsync(() -> {
    LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(1));
    System.out.println("initial stage");
    return "";
}).thenApply(s -> {
    LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(1));
    System.out.println("second stage");
    return s;
}).thenApply(s -> {
    LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(1));
    System.out.println("third stage");
    return s;
}).thenAccept(s -> {
    System.out.println("last stage");
});

f.cancel(true);
report("f", f);

ForkJoinPool.commonPool().awaitQuiescence(1, TimeUnit.DAYS);