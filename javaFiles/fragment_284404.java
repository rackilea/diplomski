final List<Pair<Runnable, CompletableFuture<Void>>> futures = tasks.stream()
        .map(task -> new Pair<>(task, CompletableFuture.runAsync(task, es)))
        .collect(toList());
try {
    CompletableFuture.allOf(futures.stream().map(Pair::getB).toArray(CompletableFuture[]::new)).join();
} catch (Exception e) {
    log.warn("At least one future failed", e);
}
es.shutdown();
futures.forEach(pair -> {
    CompletableFuture<Void> future = pair.getB();
    final boolean taskCompletedSuccessfully = !future.isCompletedExceptionally();
    log.info("Task completion status for {} : {}", pair.getA().getClass().getSimpleName(), (taskCompletedSuccessfully ? "SUCCESSFUL" : "FAILED"));
});