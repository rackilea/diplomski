class ArrayQueue<E> extends AbstractQueue<E> {

    private int cursor = 0;
    private final E[] data;

    public ArrayQueue(E[] data) {
        this.data = data;
    }

    private boolean inRange() {
        return cursor < data.length;
    }

    @Override
    public E peek() {
        return inRange() ? data[cursor] : null;
    }

    @Override
    public E poll() {
        return inRange() ? data[cursor++] : null;
    }

    @Override
    public boolean offer(E e) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        cursor = data.length;
    }

    @Override
    public Iterator<E> iterator() {
        //ommitted for brevity
    }

    @Override
    public int size() {
        return data.length - cursor;
    }

}