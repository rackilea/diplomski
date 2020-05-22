ExecutorService WORKER_THREAD_POOL 
  = Executors.newFixedThreadPool(10);
CountDownLatch latch = new CountDownLatch(2);
for (int i = 0; i < 2; i++) {
    WORKER_THREAD_POOL.submit(() -> {
        try {
            // ...
            latch.countDown();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    });
}

// wait for the latch to be decremented by the two remaining threads
latch.await();