CompletableFuture<T> compute(...) {
  CompletableFuture<T> result = new CompletableFuture<>();
  computeHelper(result, ...);
  return result;
}   

void computeHelper(CompletableFuture<T> result, ...) {
  asyncTask().thenAccept(t -> {
    if (...) {
      result.complete(t);
    } else {
      computeHelper(result, ...);
    }
  });
}