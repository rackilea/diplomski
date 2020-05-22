class MyRunnable implements Runnable { ... }

void runMyCodeInOwnThread() {
    Runnable runnable = new MyRunnable();
    ExecutorService executor = Executors.newSingleThreadExecutor();
    Future<?> future = executor.submit(runnable); // or simply "executor.execut(runnable);"
}