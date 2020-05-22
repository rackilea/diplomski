static class Wrapper<E> implements Delayed {
    E target;
    long exp = System.currentTimeMillis() + 5000; // 5000 ms delay

    Wrapper(E target) {
        this.target = target;
    }

    E get() {
        return target;
    }

    @Override
    public int compareTo(Delayed o) {
        return 0;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(exp - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }
}


public static void main(String[] args) throws Exception {
    final DelayQueue<Wrapper<Integer>> q = new DelayQueue<>();
    q.add(new Wrapper<>(1));
    Thread.sleep(3000);
    q.add(new Wrapper<>(2));

    new Thread() {
        public void run() {
            try {
                for(;;) {
                    Wrapper<Integer> w = q.take();
                    System.out.println(w.get());
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
    }.start();
}