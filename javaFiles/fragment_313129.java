public class MyTask implements Runnable {
    public void run() {
        // ...
        run(); // recursive call
        // ...
    }
}

// somewhere else:
Thread thread = new Thread(new MyTask());
thread.start();

// or even better:
ExecutorService executor = Executors.newSingleThreadExecutor();
executor.execute(new MyTask());