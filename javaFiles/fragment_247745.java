public static void main(String[] args) throws Exception {
    final BlockingQueue<String> q = new LinkedBlockingQueue<>();
    final ExecutorService executorService = Executors.newFixedThreadPool(4);
    final Runnable consumer = () -> {
        while (true) {
            try {
                System.out.println(q.take());
            } catch (InterruptedException e) {
                return;
            }
        }
    };
    executorService.submit(consumer);
    final Stream<Runnable> producers = IntStream.range(0, 5).mapToObj(i -> () -> {
        final Random random = ThreadLocalRandom.current();
        while (true) {
            q.add("Consumer " + i + " putting " + random.nextDouble());
            try {
                TimeUnit.MILLISECONDS.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {
                //ignore
            }
        }
    });
    producers.forEach(executorService::submit);
}