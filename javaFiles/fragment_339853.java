public static void main(String[] args) throws Exception {
    // start a worker thread
    ExecutorService exec = Executors.newFixedThreadPool(1);

    // ask the worker thread to execute a task (
    Future<String> future = exec.submit(() -> {
        Thread.sleep(500); // simulate waiting for I/O
        return "hello from child";
    });

    // get the return value from the worker thread (waiting until it is available)
    String greeting = future.get();
    System.out.println(greeting);

    // terminate the worker thread (otherwise, the thread will wait for more work)
    exec.shutdown();
}