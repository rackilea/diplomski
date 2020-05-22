public class RoundRobin <E> {
    private final AtomicInteger next = new AtomicInteger(0);
    private final E[] elements;

    public RoundRobin(Collection<E> queue, Class<E> clazz) {
        this.elements = queue.toArray(Array.newInstance(clazz, 0));
    }

    public E get() {
        return elements[next.getAndIncrement() % elements.length];
    }
}