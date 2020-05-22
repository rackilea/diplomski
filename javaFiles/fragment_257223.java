public <T> CompletableFuture<T> toCompletableFuture(ApiFuture<T> apiFuture) {
    final CompletableFuture<T> future = new CompletableFuture<>();
    apiFuture.addListener(() -> {
        try {
            future.complete(apiFuture.get());
        } catch (InterruptedException | ExecutionException ex) {
            logger.error(ex.getMessage());
            future.completeExceptionally(ex);
        }
    }, executionContext);
    return future;
}