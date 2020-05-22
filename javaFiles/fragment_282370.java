public SmartIterable<T> implements Iterable<SmartIterator<T>.Entry>
{
    private final Iterable<T> iterable;

    public SmartIterable(Iterable<T> iterable)
    {
        this.iterable = iterable;
    }

    public Iterator<T> iterator()
    {
        return new SmartIterator<T>(iterable.iterator());
    }
}

public SmartIterator<T> implements Iterator<SmartIterator<T>.Entry>
{
    private final Iterator<T> iterator;
    private int index = -1;

    SmartIterator(Iterator<T> iterator)
    {
        this.iterator = iterator;
    }

    public void remove()
    {
        // Could potentially just delegate
        throw new UnsupportedOperationException();
    }

    public boolean hasNext()
    {
        return iterator.hasNext();
    }

    public Entry next()
    {
        T nextValue = iterator.next();
        index++;
        return new Entry(nextValue, index);
    }

    public class Entry
    {
        private final int index;
        private final T value;

        private Entry(int index, T value)
        {
            this.index = index;
            this.value = value;
        }

        public T getValue()
        {
            return value;
        }

        public int getIndex()
        {
            return index;
        }

        public boolean isFirst()
        {
            return index == 0;
        }

        public boolean isLast()
        {
            // Call into containing instance
            return !hasNext();
        }
    }
}