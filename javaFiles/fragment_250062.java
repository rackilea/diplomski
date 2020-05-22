private static boolean running = false;
private static Lock execLock = new ReentrantLock();

public void launchExpensiveTask() {
    if (running) return; // fast exit without sync

    if (!execLock.tryLock()) return; // quit if lock is not free

    try {
        running = true;
        runExpensiveTask();
    } finally {
        running = false;
        execLock.unlock();
    }

}