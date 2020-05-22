public static void main(String[] args) throws InterruptedException {
    ExecutorService executor = Executors.newFixedThreadPool(5);
    for (int i = 1; i <= 10; i++) {
        executor.submit(new ScriptRunner("Thread_" + i));
        Thread.sleep(1000);
    }
    executor.shutdown();
}