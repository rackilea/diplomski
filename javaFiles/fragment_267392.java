public E previous() {
    checkForComodification();
    if (!hasPrevious())
        throw new NoSuchElementException();

    lastReturned = next = (next == null) ? last : next.prev; // <=====
    nextIndex--;
    return lastReturned.item;
}