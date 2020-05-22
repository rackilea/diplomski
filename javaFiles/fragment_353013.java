return mainTasksFuture.thenApply(response -> {
  CompletableFuture.runAsync(() -> {
    // extra tasks
  });
  return response;
});