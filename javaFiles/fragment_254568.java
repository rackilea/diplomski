public class Main {
    private static final Instant start = Instant.now();

    private static void debug(String message) {
        System.out.println(Duration.between(start, Instant.now()).getSeconds() + "s " + message);
    }

    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> debug("exiting")));
        debug("Hello from thread: "+Thread.currentThread().getName());
        new Game().run();
        debug("I am dying ... ");
    }

    static class Game {
        public void run() {
            value();
        }

        private int value() {
            int number = 0;
            CompletionStage<Void> c = calculate().thenApply(i -> i + 3).thenAccept(i -> debug("I am done, and my value is " + i));
            return number;
        }

        private CompletionStage<Integer> calculate() {
            CompletionStage<Integer> completionStage = new CompletableFuture<>();
            Executors.newCachedThreadPool().submit(() -> {
                debug("I am in the thread: " + Thread.currentThread().getName());
                try {
                    Thread.sleep(50000);
                    ((CompletableFuture<Integer>) completionStage).complete(3);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;

            });
            return completionStage;
        }
    }
}