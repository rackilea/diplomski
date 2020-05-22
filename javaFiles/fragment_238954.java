synchronized (someObject) {
    // code block 1
}

SwingUtilities.invokeAndWait(Runnable {
    synchronized (someObject) {
        handler();
        // code block 2
    }
});