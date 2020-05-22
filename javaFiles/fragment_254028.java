CompletableFuture<T> compute(...) {
  return asyncTask().thenCompose(t -> {
    if (...)
      return completedFuture(t);
    } else {
      return compute(...);
    }
  }
}