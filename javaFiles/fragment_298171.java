public static void main(String[] args) throws Exception {

    final class Consumer implements Runnable {

        private final BlockingQueue<Integer> q = new LinkedBlockingDeque<>();
        private final int search;

        public Consumer(final int search) {
            this.search = search;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    if (q.take() == search) {
                        System.out.println("Found magic number.");
                    }
                } catch (InterruptedException ex) {
                    return;
                }
            }
        }

        public Queue<Integer> getQ() {
            return q;
        }
    }

    final class Producer implements Runnable {

        final Random r = new Random();
        final Iterable<Queue<Integer>> qs;

        public Producer(final Iterable<Queue<Integer>> qs) {
            this.qs = qs;
        }

        @Override
        public void run() {
            while (true) {
                final int i = r.nextInt();
                for (final Queue<Integer> q : qs) {
                    q.offer(i);
                }
            }
        }
    }

    final int numConsumers = 5;
    final Collection<Queue<Integer>> qs = new LinkedList<>();
    final ExecutorService es = Executors.newCachedThreadPool();
    for (int i = 0; i < numConsumers; ++i) {
        final Consumer c = new Consumer(i);
        qs.add(c.getQ());
        es.submit(c);
    }
    es.submit(new Producer(qs));
}