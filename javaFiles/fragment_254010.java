...
CountDownLatch latch = new CountDownLatch(MYTHREADS);
CyclicBarrier cb = new CyclicBarrier(MYTHREADS, new Runnable() {
    @Override public void run() {
        sw.start();
    }
});

for (...) {
    Runnable worker = ...
    executor.execute(new Runnable() {
        @Override public void run() {
            try { 
                cb.await(); 
            } catch (Exception e) { 
                throw new RuntimeException(e); 
            }

            worker.run();
            latch.countDown();
        }
    });
}

latch.await();
sw.stop();
...