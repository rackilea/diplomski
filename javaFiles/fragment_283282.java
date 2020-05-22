final Runnable runnable1 = ...;
final Runnable runnable2 = ...;

CompletableFuture<Void> future1 = CompletableFuture.runAsync(runnable1);
CompletableFuture<Void> future2 = CompletableFuture.runAsync(runnable2);

CompletableFuture.allOf(future1, future2).get(); // waits for both runnables to finish