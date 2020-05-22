/**
 * @return a Future that will complete once the passed MyThreadImpl has been run.
 */
public CompletableFuture<Void> runThread(MyThreadImpl myThreadImpl) {
    Pair<CompletableFuture<Void>, MyThreadImpl> p = 
              new Pair<>(new CompletableFuture<>(),myThreadImpl);
    queue.add(p);
    return p.left;
}

public void run() {
    while (true) {
        try {

            Pair<CompletableFuture<MyThreadImpl>, MyThreadImpl> p = 
                  queue.take(); // will block until a job is added

            try {
                p.right.call();
                p.left.complete(null); // Future<Void> can only be completed with null. Alternatively, it could be completed with a relevant result.
            } catch (Exception e) {
                p.left.completeExceptionally(e);
            }

         } catch (InterruptedException e) {
            // trace e
         } 
   }
}