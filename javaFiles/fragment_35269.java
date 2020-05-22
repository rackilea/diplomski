CompletionStage<String> callingAsyncFunction(int developerId) {
    return getManagerIdByDeveloperId(developerId)
        .thenCompose(id -> getManagerById(id, mandatoryComputationToGetManager()));
  }

  private CompletionStage<String> getManagerById(
      Integer id, CompletionStage<String> stringCompletionStage) {
    return stringCompletionStage.thenApply(__ -> "test");
  }

  private CompletionStage<String> mandatoryComputationToGetManager() {
    return CompletableFuture.completedFuture("test");
  }