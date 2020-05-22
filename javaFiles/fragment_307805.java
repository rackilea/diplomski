public void addFirst(E e) 
{
    addBefore(e, header.next);
}

private Entry<E> addBefore(E e, Entry<E> entry) 
{
    Entry<E> newEntry = new Entry<E>(e, entry, entry.previous);
    newEntry.previous.next = newEntry;
    newEntry.next.previous = newEntry;
    size++;
    modCount++;

    return newEntry;
}