class SafeRandom implements Runnable {

    Random r = new Random();
    BlockingQueue<Double> q = new ArrayBlockingQueue<>(10);

    double get() throws InterruptedException {
        return q.take();
    }

    @Override
    public void run() {
        try {
            while (true) {
                q.put(r.nextDouble());
            }
        } catch (InterruptedException ie) {
        }
    }

}