interface Action<F, T> {

    public T process(F f);

}

class Mapper<F, T> implements Iterator<T> {

    protected final Iterator<F> input;
    protected final Action<F, T> action;

    public Mapper(Iterator<F> input, Action<F, T> action) {
        this.input = input;
        this.action = action;
    }

    @Override
    public boolean hasNext() {
        return input.hasNext();
    }

    @Override
    public T next() {
        return action.process(input.next());
    }
}

class ParallelMapper<F, T> extends Mapper<F, T> {

    // The pool.
    final ExecutorService pool;
    // The queue.
    final BlockingQueue<T> queue;
    // The next one to deliver.
    private T next = null;

    public ParallelMapper(Iterator<F> input, Action<F, T> action, int threads, int queueLength) {
        super(input, action);
        // Start my pool.
        pool = Executors.newFixedThreadPool(threads);
        // And the queue.
        queue = new ArrayBlockingQueue<>(queueLength);
    }

    class Worker implements Runnable {

        final F f;
        private T t;

        public Worker(F f) {
            this.f = f;
        }

        @Override
        public void run() {
            try {
                queue.put(action.process(f));
            } catch (InterruptedException ex) {
                // Not sure what you can do here.
            }
        }

    }

    @Override
    public boolean hasNext() {
        // All done if delivered it and the input is empty and the queue is empty and the threads are finished.
        while (next == null && (input.hasNext() || !queue.isEmpty() || !pool.isTerminated())) {
            // First look in the queue.
            next = queue.poll();
            if (next == null) {
                // Queue empty.
                if (input.hasNext()) {
                    // Start a new worker.
                    pool.execute(new Worker(input.next()));
                }
            } else {
                // Input exhausted - shut down the pool - unless we already have.
                if (!pool.isShutdown()) {
                    pool.shutdown();
                }
            }
        }
        return next != null;
    }

    @Override
    public T next() {
        T n = next;
        if (n != null) {
            // Delivered that one.
            next = null;
        } else {
            // Fails.
            throw new NoSuchElementException();
        }
        return n;
    }
}

public void test() {
    List<Integer> data = Arrays.asList(5, 4, 3, 2, 1, 0);
    System.out.println("Data");
    for (Integer i : Iterables.in(data)) {
        System.out.println(i);
    }
    Action<Integer, Integer> action = new Action<Integer, Integer>() {

        @Override
        public Integer process(Integer f) {
            try {
                // Wait that many seconds.
                Thread.sleep(1000L * f);
            } catch (InterruptedException ex) {
                // Just give up.
            }
            // Return it unchanged.
            return f;
        }

    };
    System.out.println("Processed");
    for (Integer i : Iterables.in(new Mapper<Integer, Integer>(data.iterator(), action))) {
        System.out.println(i);
    }
    System.out.println("Parallel Processed");
    for (Integer i : Iterables.in(new ParallelMapper<Integer, Integer>(data.iterator(), action, 2, 2))) {
        System.out.println(i);
    }

}