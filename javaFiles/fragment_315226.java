try {
    Thread.sleep(...);
} catch (InterruptedException e) {
    // re-establish the interrupt condition
    Thread.currentThread.interrupt();
    // probably stop the thread
    return;
}