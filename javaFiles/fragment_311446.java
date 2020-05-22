public CompletableFuture<List<Employee>> handleFutures(
        CompletableFuture<Factory> factoryCompletableFuture,
        CompletableFuture<Task> taskCompletableFuture) {
    return factoryCompletableFuture.thenCombine(taskCompletableFuture,
        (factory, task) -> factory.getEmployees().stream()
            .flatMap(Collection::stream)
            .peek(empl -> empl.setTask(task))
            .collect(toList()));
}