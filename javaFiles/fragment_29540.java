Thread consumer = new Thread(new Consumer(queue));
consumer.start();

class Consumer implements Runnable {
    private ExecutorService     service = Executors.newCachedThreadPool();
    private final BlockingQueue queue;

    public Consumer(Queue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        Task t = null;
        while(t = queue.take()) {
            Worker worker = new Worker(t);
            service.execute(worker);
        }
    }
}