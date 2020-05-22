CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> {
    LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(1));
    return "a string";
});

CompletableFuture<Integer> f2 = f1.thenApply(s -> {
    LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(2));
    return s.length();
});

f2.thenAccept(i -> System.out.println("result of f2 = "+i));

String s = f1.join();
System.out.println("result of f1 = "+s);

ForkJoinPool.commonPool().awaitQuiescence(1, TimeUnit.DAYS);