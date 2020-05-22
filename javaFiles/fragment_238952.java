synchronized (someObject) {
    // code block 1
}

SwingUtilities.invokeAndWait(handler);

synchronized (someObject) {
    // code block 2
}