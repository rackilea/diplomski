public class MyBlockingQueue<E> extends ArrayBlockingQueue<E> {
    private final long timeoutMS;

    public MyBlockingQueue(int capacity, long timeoutMS) {
        super(capacity);
        this.timeoutMS = timeoutMS;
    }

    @Override
    public boolean offer(E e) {
        try {
            return super.offer(e, timeoutMS, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e1) {
            Thread.currentThread().interrupt();
            return false;
        }
    }
}