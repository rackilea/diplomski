public abstract class ApproximateLocation<K extends Comparable<K>, T> {

    protected abstract K orderingKey(T element);

    private final ConcurrentMap<K, Wrapper<T>> _map = new ConcurrentSkipListMap<K, Wrapper<T>>();
    private final Deque<Wrapper<T>> _fifo = new LinkedBlockingDeque<Wrapper<T>>();
    private final AtomicInteger _counter = new AtomicInteger();

    public void add(T element) {
        K key = orderingKey(element);
        Wrapper<T> wrapper = new Wrapper<T>(_counter.getAndIncrement(), element);
        _fifo.add(wrapper);
        _map.put(key, wrapper);
    }

    public T pop() {
        Wrapper<T> wrapper = _fifo.pop();
        _map.remove(orderingKey(wrapper.value));
        return wrapper.value;
    }

    public int approximateLocation(T element) {
        Wrapper<T> wrapper = _map.get(orderingKey(element));
        Wrapper<T> first = _fifo.peekFirst();
        Wrapper<T> last = _fifo.peekLast();
        if (wrapper == null || first == null || last == null) {
            // element is not in composite structure; fifo has not been written to yet because of concurrency
            return -1;
        }
        int min = Math.min(wrapper.id, Math.min(first.id, last.id));
        int max = Math.max(wrapper.id, Math.max(first.id, last.id));
        if (wrapper == first || max == min) {
            return 0;
        }
        if (wrapper == last) {
            return max - min;
        }
        return wrapper.id - min;
    }

    private static class Wrapper<T> {
        final int id;
        final T value;

        Wrapper(int id, T value) {
            this.id = id;
            this.value = value;
        }
    }
}