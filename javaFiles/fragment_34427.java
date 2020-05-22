private final E[] mArray;

private CircularBuffer(int size, Class<E> type) {
    mSize = size;
    mArray = (E[]) Array.newInstance(type, size);
}