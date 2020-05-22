private static boolean running = false;
private static Object execLock = new Object();

private boolean start() {
    synchronized (execLock) {
        boolean ret = running;
        running = true;
        return ret;
    }
}

private void end() {
    synchronized (execLock) {
        running = false;
    }
}

public void launchExpensiveTask() {
    if (running) return; // fast exit without sync

    if (start()) return; // already running, do nothing

    try {
        runExpensiveTask();
    } finally {
        end();
    }
}