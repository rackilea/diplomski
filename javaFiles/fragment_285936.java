...
public Future<Void> doTheJob() { 
    System.out.println("Doing the job...");
    Future<Void> future = Future.future();
    Vertx vertx = Vertx.vertx();
    vertx.executeBlocking(call -> {
        executeLongRunningBlockingOperation();
        call.complete;
    }, result -> {
        // this will only be called once the blocking operation is done
        future.complete();
    });
    // this method returns immediately since we are not blocking the main thread
    return future;
}
...