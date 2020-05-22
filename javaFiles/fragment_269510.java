public void test(String[] args) {
    // My queue
    BlockingQueue<BigInteger> queue = new ArrayBlockingQueue<>(10);

    // A Stream of it's contents.
    Stream<BigInteger> biStream = Stream.generate(() -> {
        try {
            return queue.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    });

    // Feed the queue from a thread.
    new Thread(new Runnable() {
        // Must be final to be accessible inside `run`.
        final AtomicInteger i = new AtomicInteger();

        @Override
        public void run() {
            // Slow feed to the queue.
            while (true) {
                // Add a new number to the queue.
                queue.add(BigInteger.valueOf(i.getAndIncrement()));
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }).start();

    // DEMO - Consumes the queue printing contents as they arrive.
    biStream.filter(x -> x.testBit(2))
            .limit(20)
            .forEach(x -> System.out.println(x));
}