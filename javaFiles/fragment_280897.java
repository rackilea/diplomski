while (true) {
    // Invoke your method
    ProcessPage(url, word);

    // Sleep (if you want to stay in the same thread)
    try {
        Thread.sleep(1000*60*10);
    } catch (InterruptedException e) {
        // Handle exception somehow
        throw new IllegalStateException("Interrupted", e);
    }
}