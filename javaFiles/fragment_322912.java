private static class Consumer implements Runnable {

    private final BlockingQueue<String> blockingQueue;

    public Consumer(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                final String s = blockingQueue.take();
                System.out.println(s);
                if ("EXIT".equalsIgnoreCase(s)) {
                    return;
                }
            } catch (InterruptedException ex) {
                return;
            }
        }
    }
}

public static interface ProducerMBean {

    void add(String string);

    String contents();
}

private static class Producer implements ProducerMBean {

    private final BlockingQueue<String> blockingQueue;

    public Producer(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void add(String string) {
        blockingQueue.add(string);
    }

    @Override
    public String contents() {
        return blockingQueue.toString();
    }
}

public static void main(String[] args) throws Exception {
    final ExecutorService executorService = Executors.newSingleThreadExecutor();
    final BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>();
    executorService.submit(new Consumer(blockingQueue));
    final Producer producer = new Producer(blockingQueue);
    final ObjectName name = new ObjectName("com.example.producer:type=SomeUnqiueName");
    ManagementFactory.getPlatformMBeanServer().registerMBean((ProducerMBean) producer, name);
    executorService.shutdown();
}