private CompletableFuture<MyEntity> save(MyEntity me) {
    CompletableFuture<MyEntity> future = ContextAwareCompletableFuture
        .supplyAsync(() -> repository.save(me));
    CompletableFuture<Void> fooFuture = future
        .thenAcceptAsync((e) -> foo(e));
    CompletableFuture<Void> barFuture = future
        .thenAcceptAsync((e) -> bar(e));
    return future
        .thenCombine(fooFuture, (result, fooResult) -> result)
        .thenCombine(barFuture, (result, barResult) -> result);
}