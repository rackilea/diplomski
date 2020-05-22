public void sort(Comparator<? super E> c) {
    final ReentrantLock lock = this.lock;
    lock.lock();**
    try {
        Object[] elements = getArray();
        Object[] newElements = Arrays.copyOf(elements, elements.length);
        @SuppressWarnings("unchecked") E[] es = (E[])newElements;
        Arrays.sort(es, c);
        setArray(newElements);
    } finally {
        lock.unlock();
    }
}