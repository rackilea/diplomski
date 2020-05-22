public class CompletableFutureAllOfCompletion {
    private ExecutorService executor1 = Executors.newFixedThreadPool(2);
    private ExecutorService executor2 = Executors.newFixedThreadPool(2);
    private Random random = new Random();

    public static void main(String[] args) {
        new CompletableFutureAllOfCompletion().run();
    }

    public void run() {
        CompletableFuture<Integer> cf1 = supplyAsync(this::randomSleepAndReturn, executor1);
        CompletableFuture<Integer> cf2 = supplyAsync(this::randomSleepAndReturn, executor1);
        CompletableFuture<Integer> cf3 = supplyAsync(this::randomSleepAndReturn, executor2);
        randomSleepAndReturn();
        CompletableFuture.allOf(cf1, cf2, cf3)
                .thenRun(() -> System.out.println("allOf() commpleted on "
                        + Thread.currentThread().getName()));

        executor1.shutdown();
        executor2.shutdown();
    }

    public int randomSleepAndReturn() {
        try {
            final long millis = random.nextInt(1000);
            System.out.println(
                    Thread.currentThread().getName() + " waiting for " + millis);
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 0;
    }
}