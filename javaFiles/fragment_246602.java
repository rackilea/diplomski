CompletableFuture cf1 = CompletableFuture.supplyAsync(() -> {
    System.out.println("enter into completableFuture()");
    LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(1));
    System.out.println("start to out of completableFuture()");
    return "a";
});
System.out.println("do something else");
CompletableFuture last
    = cf1.thenApply(v -> v + " b").thenAcceptAsync(System.out::println);
System.out.println("finalize...");
last.join();