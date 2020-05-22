List<ListenableFuture<Object>> requiredTasks = ...;

ListenableFuture<List<Object>> requiredTasksResult = Futures.allAsList(requiredTasks);

ListenableFuture<Object> resultFuture = Futures.transform(requiredTasksResult, new Function<List<Object>, Object>() {
    public Object apply(List<Object> results) {
        // Apply computing formula
    }
}, threadPool); // Function will be executed in threadPool

Object result = resultFuture.get(10, TimeUnit.SECONDS);