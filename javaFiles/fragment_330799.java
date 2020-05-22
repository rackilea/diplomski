try {
    ...
} catch (InterruptedException e) {
    // immediately re-interrupt the thread
    Thread.currentThread().interrupt();
    // log the exception or [likely] quit the thread
}