class MyRunnable implements Runnable { ... }

void runMyCodeInOwnThread() {
    Runnable runnable = new MyRunnable();
    Thread thread = new Thread(runnable);
    thread.start();
}