@Async
public CompletableFuture<Long> doAsync(String email){
    //do something
    Long result = ...
    return CompletableFuture.completedFuture(result);
}