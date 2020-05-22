public <T> CompletableFuture<T> toCompletableFuture(ApiFuture<T> apiFuture) {
    final CompletableFuture<T> future = new CompletableFuture<>();
    ApiFutures.addCallback(apiFuture, new ApiFutureCallback<T>() {
        @Override
        public void onFailure(Throwable t) {
            future.completeExceptionally(t);
        }

        @Override
        public void onSuccess(T result) {
            try {
                future.complete(apiFuture.get());
            } catch (InterruptedException | ExecutionException ex) {
                logger.error(ex.getMessage());
                future.completeExceptionally(ex);
            }
        }
    }, executionContext);
    return future;
}