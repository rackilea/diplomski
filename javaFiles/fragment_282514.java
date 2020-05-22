class MyTask implements Callable<String> {
    private volatile Thread executorThread;

    @Override
    String call() {
        executorThread = Thread.currentThread(); // not getCurrentThread()
        Thread.sleep(10000);
        return "";
    }

    Thread getExecutorThread() {
        return executorThread;
    }
}