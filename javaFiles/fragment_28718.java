try {
    queue.take();
 } catch (InterruptedException ie) {
    // because catching InterruptedException clears the thread interrupt bit,
    // we immediately re-interrupt the current thread.
    Thread.currentThread().interrupt();
    // handle the interrupt here by quitting or returning or ...
 }