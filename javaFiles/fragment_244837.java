public T removeFirst() {
    T removed = first.data;
    if (first.next == null) {
        last = null;
    }
    first = first.next;
    return removed;
}

public T peekFirst() {
    return first.data;
}