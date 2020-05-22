TempState tempState;
SwingUtilities.invokeAndWait(Runnable() {
    synchronized (someObject) {
        handler();
        tempState.update();
    }
);

synchronized (someObject) {
    // code block 1
    // instead of invokeAndWait, use tempState from above
    // code block 2
}