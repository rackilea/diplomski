for (Supplier<Boolean> method : methods)
{
    if (future == null)
    {
        future = CompletableFuture.supplyAsync(method, threadPool);
    }
    else
    {
        future.thenApplyAsync(result -> result && method.get(), threadPool);
    }
}