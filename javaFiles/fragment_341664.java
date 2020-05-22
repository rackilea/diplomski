private class DoubleListIterator implements Iterator<E> {
// instance variable
private Node current = head;
private int index = 0;

public boolean hasNext() {
    return index < N;
}

public E next() {
    if (!hasNext()) {
        throw new NoSuchElementException();
    } else {
        index++;
        E temp = current.item;
        current = current.next;
        return temp;
    }
}

public void remove() {
    throw new UnsupportedOperationException();
}
}