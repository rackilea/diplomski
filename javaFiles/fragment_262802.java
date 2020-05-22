private final BlockingQueue<Object> queue = new LinkedBlockingQueue<>();
private volatile boolean running = true;
private final CountDownLatch terminationLatch = new CountDownLatch(1);

// Consumer thread
while (running || !queue.isEmpty()) {
    Object element = queue.poll(100, TimeUnit.MILLISECONDS);
    if (element == null) continue;
    consume(element);
}
terminationLatch.countDown();

// Finalizer thread
running = false;
terminationLatch.await();