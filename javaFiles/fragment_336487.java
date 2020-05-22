public E next() 
{
        checkForComodification();
        try {
        E next = get(cursor);
        lastRet = cursor++;
        return next;
        } catch (IndexOutOfBoundsException e) {
        checkForComodification();
        throw new NoSuchElementException();
        }
}

final void checkForComodification() 
{
    // Initially modCount = expectedModCount (our case 5)
        if (modCount != expectedModCount)
        throw new ConcurrentModificationException();
}