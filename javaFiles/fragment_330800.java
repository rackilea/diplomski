assertFalse(Thread.currentThread().isInterrupted());
// you can do this from another thread by saying: someThread.interrupt();
Thread.currentThread().interrupt();
// this method does _not_ clear the interrupt flag
assertTrue(Thread.currentThread().isInterrupted());
// but this one _does_ and should probably not be used
assertTrue(Thread.interrupted());
assertFalse(Thread.currentThread().isInterrupted());
Thread.currentThread().interrupt();
assertTrue(Thread.currentThread().isInterrupted());
try {
    // this throws immediately because the thread is _already_ interrupted
    Thread.sleep(1);
    fail("will never get here");
} catch (InterruptedException e) {
    // and when the InterruptedException is throw, it clears the interrupt
    assertFalse(Thread.currentThread().isInterrupted());
    // we should re-interrupt the thread so other code can use interrupt status
    Thread.currentThread().interrupt();
}
assertTrue(Thread.currentThread().isInterrupted());