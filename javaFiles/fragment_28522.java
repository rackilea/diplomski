class AsyncQueue<E> {

    Queue<Consumer<E>> callbackQueue = new LinkedList<>();
    Queue<E> elementQueue = new LinkedList<>();

    public synchronized void add(E e) {
        if (callbackQueue.size() > 0)
            callbackQueue.remove().accept(e);
        else
            elementQueue.offer(e);
    }

    public synchronized void poll(Consumer<E> c) {
        if (elementQueue.size() > 0)
            c.accept(elementQueue.remove());
        else
            callbackQueue.offer(c);
    }
}