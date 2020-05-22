public class CircularBlockingQueue<E> {
    private final ArrayBlockingQueue<E> blockingQueue;

    public CircularBlockingQueue(int size) {
        blockingQueue = new ArrayBlockingQueue<>(size);
    }

    public int size() {
        return blockingQueue.size();
    }

    public void add(E element) {
        while(!blockingQueue.offer(element)) {
            blockingQueue.poll();
        }
    }

    public E take() throws InterruptedException {
        return blockingQueue.take();
    }
}