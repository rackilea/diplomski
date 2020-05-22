@Test
public void test() throws ExecutionException, InterruptedException {
    ExecutorService threadExecutor = Executors.newFixedThreadPool(1);
    CompletableFuture c1 = new CompletableFuture();
    CompletableFuture c2 = new CompletableFuture();
    Future<String> future = threadExecutor.submit(() -> {
        try {
            c1.complete(null);
            Thread.sleep(10000);
            c2.complete("normal");
        } catch (InterruptedException e) {
            c2.complete("interrupted");
        }
        return "aaa";
    });
    c1.join(); // waits for the task start
    // future.get(); // awaits the completion
    System.out.println("cancel:     " + future.cancel(true));
    //System.out.println("cancel:     " + future.cancel(false));
    System.out.println("isDone:     " + future.isDone());
    System.out.println("isCanceled: " + future.isCancelled());
    System.out.println("task:       " + c2.join());
}