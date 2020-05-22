public class NullIgnoringArrayList<T> extends ArrayList<T> {

    ...

    @Override
    public ListIterator<T> listIterator() {
        return new SimpleListIterator<>(super.listIterator());
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return new SimpleListIterator<>(super.listIterator(index));
    }
}

public class SimpleListIterator<T> implements ListIterator<T> {

    private final ListIterator<T> underlying;

    public SimpleListIterator(ListIterator<T> underlying) {
        this.underlying = underlying;
    }

    @Override public boolean hasNext() {return underlying.hasNext();}
    @Override public T next() { return underlying.next(); }
    @Override public boolean hasPrevious() {return underlying.hasPrevious();}
    @Override public T previous() {return underlying.previous();}
    @Override public int nextIndex() {return underlying.nextIndex();}
    @Override public int previousIndex() {return underlying.previousIndex();}
    @Override public void remove() { underlying.remove();}

    @Override
    public void set(T o) {
        if (isNull(o)) {return;}
        underlying.set(o);
    }

    @Override
    public void add(T o) {
        if (isNull(o)) {return;}
        underlying.add(o);
    }
}