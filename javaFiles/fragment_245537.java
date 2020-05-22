/**
 * Removes all of the elements from this list.
 */
public void clear() {
    Entry<E> e = header.next;
    while (e != header) {
        Entry<E> next = e.next;
        e.next = e.previous = null;
        e.element = null;
        e = next;
    }
    header.next = header.previous = header;
    size = 0;
modCount++;
}