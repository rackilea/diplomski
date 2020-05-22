try {
    Thread.sleep(NOTE_DURATION);
} catch (InterruptedException e) {
    // re-establish the interrupt condition
    Thread.currentThread.interrupt();
    ...
}