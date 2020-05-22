playersLatch.countDown();
try {
    playersLatch.await();
} catch (InterruptedException ex) {
    //handle interruption
}