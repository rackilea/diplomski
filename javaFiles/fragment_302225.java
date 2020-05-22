public class WordCountTest {
    public static void main(String[] args){
        Queue<Integer> threadQueue = new ConcurrentLinkedQueue<>();
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        CountDownLatch latch = new CountDownLatch(args.length);

        for (int i = 0; i<args.length; i++){
            CompletableFuture.runAsync(new WordCount(args[i], threadQueue), executor)
                .thenRunAsync(latch.countDown(), executor);
        }

        latch.await();

        int sum = 0;
        for(Integer i : threadQueue) {
            sum += i;
        }
    }
}