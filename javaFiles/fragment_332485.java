public class MyThreadPool implements Executor {

    private List<Thread> threads = new ArrayList<>();
    private BlockingDeque<Callable> tasks = new LinkedBlockingDeque<>();
    private volatile boolean running = true;

    public MyThreadPool(int numberOfThreads) {
        for (int i = 0; i < numberOfThreads; i++) {
            Thread t = new Thread(() -> {
                while (running) {
                    try {
                        Callable c = tasks.poll(5L, TimeUnit.SECONDS);
                        if (c != null) {
                            c.call();
                        }
                    } catch (Exception e) { /* NOP */ }
                }
            });
            t.start();
            threads.add(t);
        }
    }

    public void shutdown() {
        running = false;
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) { /* NOP */ }
        }
    }

    // ...

}