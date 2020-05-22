CompletableFuture<T> result = CompletableFuture.supplyAsync(task, executor);

//...

CompletableFuture<T> finalStage = new CompletableFuture<>();
finalStage.thenRun(() -> {
    //...
});

// ...

if(x == 1) {
    result = result.thenApplyAsync(t -> {

        return null;
    });
}
result.whenComplete((v,t) -> {
    if(t != null) finalStage.completeExceptionally(t); else finalStage.complete(v);
});