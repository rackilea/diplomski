public class Test {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        AtomicInteger counter = new AtomicInteger();

        for (int i = 0; i < 10; i++) {
            executor.execute(new Worker(counter));
        }

        executor.shutdown();
        if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
            // executor does not shut down.
            // try executor.shutdownNow() etc.
        }

        System.out.println("Total Count: " + counter.get());
    }
}

class Worker implements Runnable {
    private final AtomicInteger counter;

    public Worker(AtomicInteger counter) {
        this.counter = counter;
    }

    public void run() {
        // do something
        counter.incrementAndGet();
        // do something else
    }
}