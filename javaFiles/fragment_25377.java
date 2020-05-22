public CompletableFuture<List<T>> databaseQuery(String query, String[] args) {
    CompletableFuture<List<T>> future = new CompletableFuture<>();
    Executor executor = ForkJoinPool.commonPool();

    executor.execute(() -> {
        String preparedQuery = QueryBaker(Query, args);
        List<T> list = DB_Exec(preparedQuery); // time taking task
        future.complete(list);
    });
}