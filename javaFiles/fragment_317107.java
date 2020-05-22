try {
    while (!Thread.currentThread().isInterrupted() && /* more work to do */) {
        // do more work
        Thread.sleep(1000);
    }
} catch (InterruptedException e) {
    // thread was interrupted during sleep or wait
}