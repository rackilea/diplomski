CountDownLatch latch = new CountDownLatch(1);

//code that triggers the signal
latch.countDown();

//code that waits for the signal
try {
    latch.await();
} catch (InterruptedException e) {
    //handle interruption
}