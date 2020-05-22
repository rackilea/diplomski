import java.util.ArrayDeque;

public class CircularBlockingQueue<E> {
    private final ArrayDeque<E> blockingQueue;
    private final int maxSize;

    public CircularBlockingQueue(int size) {
        if(size<1) throw new IllegalArgumentException("size == "+size);
        blockingQueue = new ArrayDeque<>(size);
        maxSize = size;
    }

    public synchronized int size() {
        return blockingQueue.size();
    }

    public synchronized void add(E element) {
        if(blockingQueue.size() == maxSize) {
            blockingQueue.poll();
        }
        blockingQueue.add(element);
        notify();
    }

    public synchronized E take() throws InterruptedException {
        while(blockingQueue.isEmpty()) wait();
        return blockingQueue.remove();
    }
}