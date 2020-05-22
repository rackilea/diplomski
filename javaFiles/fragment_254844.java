CompletableFuture<List<FutureResponse>> = CompletableFuture.supplyAsync(() -> {
    // start fetches and collect the individual futures
    List<CompletableFuture> fetches = 
       allBeans.values().stream()
               .map(SomeClass::fetchData)
               .collect(toList());
    // join all futures and return the list of the results
    return fetches.stream()
               .map(CompletableFuture::join)
               .collect(toList());
}