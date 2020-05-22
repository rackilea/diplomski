ExecutorService threadExecutor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

// Must be available in Runnables
final CountDownLatch latch = new CountDownLatch(size);

int totalNumberOfTasks = 0;
for(int i = 0; i < size; i++) {
    if(expr != null) {
        totalNumberOfTasks++;
        threadExecutor.execute(new Runnable() {

            @Override
            public void run() {
                doSmth();
                latch.countDown(); // Countdown the latch
            }
        });
    }
}

try {
    latch.await();
} catch (InterruptedException e) {
    e.printStackTrace();
}