public ListIterator<E> listIterator(int index) {
    return new ListItr(index);
}

private class ListItr implements ListIterator<E> {
    private Entry<E> lastReturned = header;
    private Entry<E> next;
    private int nextIndex;
    private int expectedModCount = modCount;
    ....