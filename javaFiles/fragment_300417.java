@Async
public  CompletableFuture<Boolean> veryLongMethod()  {

    try {
        Thread.sleep(2000L);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    return CompletableFuture.completedFuture(true);
}