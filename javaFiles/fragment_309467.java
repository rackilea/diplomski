// Create futures for the two tasks to run concurrently
CompletableFuture<MyObject> checkCache = CompletableFuture.supplyAsync(() -> cache.lookup(key));
CompletableFuture<MyObject> callExternal = CompletableFuture.supplyAsync(() -> externalService.lookup(key));
// run the two operations, and react to the first to complete
checkCache.applyToEither(callExternal, 
                         result -> {
                             cache.store(key, result);
                             return result;
                         })
           .applyTo(result -> // do something with the returned value);