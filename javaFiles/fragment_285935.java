public void executeLongRunningBlockingOperation() {
    Thread.sleep(5000);
}

public Future<Void> doTheJob() { 
    System.out.println("Doing the job...");
    Future<Void> future = Future.future();
    executeLongRunningBlockingOperation();
    // this line will not be called until executeLongRunningBlockingOperation returns!
    future.complete();
    // nor will this method! This means that the method won't return until the long operation is done!
    return future;
}

public static void main(String[] args) {
    doTheJob().setHandler(asyncResult -> {
        System.out.println("Finished the job");
    });
    System.out.println("Doing other stuff in the mean time...");
}