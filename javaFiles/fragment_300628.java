public CompletableFuture<Void> loadAndApply(SomeObject object) {
  return loadData().thenCompose(data ->
      CompletableFuture.allOf(
          CompletableFuture.runAsync(() -> object.setA(processA(data)), swingExecutor),
          CompletableFuture.runAsync(() -> object.setB(processB(data)), backgroundExecutor)
      ) // End of "allOf"
  ); // End of "thenCompose"
} // End of "loadAndApply"