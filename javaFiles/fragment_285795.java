public synchronized void keyPress(int keycode) {
    checkKeycodeArgument(keycode);
    peer.keyPress(keycode);
    afterEvent();
}

public synchronized void mousePress(int buttons) {
    checkButtonsArgument(buttons);
    peer.mousePress(buttons);
    afterEvent();
}

// etc

private void afterEvent() {
    autoWaitForIdle();
    autoDelay();
}

private void autoWaitForIdle() {
    if (isAutoWaitForIdle) {
        waitForIdle();
    }
}

public synchronized void waitForIdle() {
    checkNotDispatchThread();
    /* snip */
}

private void checkNotDispatchThread() {
    if (EventQueue.isDispatchThread()) {
        throw new IllegalThreadStateException("Cannot call method from the event dispatcher thread");
    }
}