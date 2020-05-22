public static void main(String[] args) throws Exception {
    CompletableFuture<String> future = new CompletableFuture<String>();
    future.whenComplete((r, t) -> {
        System.out.println("before sleep, executed in thread " + Thread.currentThread());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("after sleep, executed in thread " + Thread.currentThread());
    });

    System.out.println(Thread.currentThread());
    future.complete("completed");
    System.out.println("done");
}