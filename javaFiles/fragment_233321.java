public class Producer implements Runnable {
    public void run() {
        ExecutorService executor = ... // create new executor

        // queue items
        for (Object item : itemSource) {
            executor.schedule(new Consumer(item));
        }

        // shutdown executor
        executor.shutdown();
        executor.awaitTermination(2, TimeUnit.HOURS);
    }
}

ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

scheduler.scheduleWithFixedDelay(new Producer(), 30, 30, TimeUnit.MINUTES);
// or
scheduler.scheduleAtFixedRate(new Producer(), 30, 30, TimeUnit.MINUTES);