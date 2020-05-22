public CompletionStage<Result> getData() {
    CompletableFuture<List<SqlRow>> cf = new CompletableFuture<>();
    return cf.supplyAsync(() -> {
        return Ebean.createSqlQuery("SELECT * FROM Users").findList();
    }, ec) // <-- 'ec' is the ExecutorService you want to use
    .thenApply(rows -> {
       return ok(Json.toJson(rows));
    }); 
}