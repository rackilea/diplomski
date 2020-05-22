public class DualPriorityQueue<T> {

    private Queue<T> queue1, queue2;
    private Map<T, Integer> counts;

    public DualPriorityQueue(int size, Comparator<T> c1, Comparator<T> c2) {
        queue1 = new PriorityQueue(size, c1);
        queue2 = new PriorityQueue(size, c2);
        counts = new HashMap<T, Integer>(size);
    }

    public T poll1() {
        return poll(queue1);
    }

    public T poll2() {
        return poll(queue2);
    }

    private T poll(Queue<T> queue) {
        T t = null;
        while (!queue.isEmpty() && !removeCount(t = queue.poll())) {
            t = null;
        }
        return t;
    }

    public boolean offer(T t) {
        queue1.offer(t);
        queue2.offer(t);
        addCount(t);
        return true;
    }

    private boolean removeCount(T t) {
        final Integer value = counts.get(t);
        if (value != null && value > 0) {
            final int newValue = value - 1;
            if (newValue == 0) {
                counts.remove(t);
            } else {
                counts.put(t, newValue);
            }
            return true;
        }
        return false;
    }

    private void addCount(T t) {
        final Integer prev = counts.get(t);
        if (prev == null || prev <= 0) {
            counts.put(t, 1);
        } else {
            counts.put(t, prev + 1);
        }
    }
}