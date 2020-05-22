private class ListIterator<T> implements Iterator<T>
{
    private int curPos, expectedCount;
    private Node<T> itNode;
    private ListIterator()
    {
        curPos = 0;
        expectedCount = modCount;
        itNode = sentinel;
    }

    public boolean hasNext()
    {
        return (curPos < expectedCount);
    }

    public T next()
    {
        // snip
    }
}