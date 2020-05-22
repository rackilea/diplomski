try {
    while (!Thread.currentThread().isInterrupted()) {
        // do something
        Thread.sleep(5000);
    }
} catch (InterruptedException e) {
    // flag value is not used here
    Thread.currentThread().interrupt(); 
}