public class Node {
    private int key;
    private Node prev, next;
    private ConcurrentLinkedQueue<Integer> queue;
    private AtomicBoolean lock = new AtomicBoolean(false);
    private ThreadPoolExecutor executor;
    private UpdateNode updater = new UpdateNode();

    public void update(int i) {
        queue.offer(i);
        if(lock.compareAndSet(false, true)) {
            executor.execute(updater);
        }
    }

    private class UpdateNode implements Runnable {
        public void run() {
            do {
                try {
                    int temp = key;
                    while(!queue.isEmpty()) {
                        temp += queue.poll();
                    }
                    if(prev.getKey() > temp) {
                        // remove node, update key to temp, perform backward linear traversal, and insert
                    } else if(next.getKey() < temp) {
                        // remove node, update key to temp, perform forward linear traveral, and insert
                    } else {
                        key = temp; // node doesn't change position
                    }
                } finally {
                    lock.set(false);
                }
            } while (!queue.isEmpty() && lock.compareAndSet(false, true));
        }
    }
}