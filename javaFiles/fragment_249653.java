public static void main(String[] args) {
    final CompletableFuture<Object> future = CompletableFuture.supplyAsync(() -> {
        waitAndLog("Supplier", null, 1000);
        throw new RuntimeException("First");
    }).thenApply(Function.identity());
    long start = System.nanoTime();

    CompletableFuture.runAsync(() -> waitAndLog("A", future, 0));

    LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(10));

    future.exceptionally(e -> {
        waitAndLog("Exceptionally", null, 1000);
        return null;
    });

    CompletableFuture.runAsync(() -> waitAndLog("B", future, 0));
    CompletableFuture.runAsync(() -> waitAndLog("C", future, 1100));

    waitAndLog("Main", future, 0);
    ForkJoinPool.commonPool().awaitQuiescence(10, TimeUnit.SECONDS);
}
private static void waitAndLog(String msg, CompletableFuture<?> primary, int sleep) {
    long nanoTime = System.nanoTime();
    Object result;
    try {
        if(sleep>0) Thread.sleep(sleep);
        result = primary!=null? primary.get(): null;
    } catch (InterruptedException|ExecutionException ex) {
        result = ex;
    }
    long millis=TimeUnit.NANOSECONDS.toMillis(System.nanoTime()-nanoTime);
    System.out.println(msg+" waited for "+millis+"ms"+(result!=null? ", got "+result: ""));
}