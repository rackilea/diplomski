private CompletableFuture<MyEntity> save(MyEntity me) {
    CompletableFuture<MyEntity> future = ContextAwareCompletableFuture
        .supplyAsync(() -> repository.save(me));
    CompletableFuture<MyEntity> fooFuture = future
        .thenApplyAsync((e) -> { foo(e); return e; });
    CompletableFuture<MyEntity> barFuture = future
        .thenApplyAsync((e) -> { bar(e); return e; });
    return fooFuture
        .thenCombine(barFuture, (fooResult, barResult) -> fooResult);
}