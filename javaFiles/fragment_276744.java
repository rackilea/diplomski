package test;

import java.util.concurrent.*;

public class FixedRateConsumer {

private BlockingQueue<String> queue = new ArrayBlockingQueue<>(20);

private ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(5);

private boolean continueRunning = true;

public void executeInBackGraound() throws InterruptedException, ExecutionException {
    while (continueRunning) {
        String s = queue.take();
        Worker w = new Worker(s);
        ScheduledFuture future = executorService.scheduleAtFixedRate(w, 0, 1, TimeUnit.SECONDS);
        w.future = future;

        try {
            if (!future.isDone()) {
                future.get();
            }
        } catch (CancellationException e) {
            // Skipping
        }
    }
}

public void setContinueRunning(boolean state) {
    continueRunning = state;
}

public void addConsumableObject(String s) throws InterruptedException {
    queue.put(s);
}

private void consumeString(String s) {
    System.out.println("Consumed -> " + s + ", ... @ -> "  + System.currentTimeMillis() + " ms");
}

private class Worker implements Runnable {
    String consumableObject;
    ScheduledFuture future;

    public Worker(String initialConsumableObject) {
        this.consumableObject = initialConsumableObject;
    }

    @Override
    public void run() {
        try {
            if (consumableObject == null) {
                consumableObject = queue.take();
            }

            consumeString(consumableObject);

            consumableObject = null;
            if (queue.isEmpty()) {
                if (future == null) {
                    while (future == null) {
                        Thread.sleep(50);
                    }
                }

                future.cancel(false);
            }

        } catch (Exception e) {
            System.out.println("Exception : " + e);
        }
    }
}
}