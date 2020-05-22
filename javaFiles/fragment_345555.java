public class ObservableArrayList<T> extends ModifiableObservableListBase<T> {
    private final List<E> delegate = new ArrayList<>();

    @Override
    public E get(final int index) {
        return delegate.get(index);
    }

    @Override
    public int size() {
        return delegate.size();
    }

    @Override
    protected void doAdd(final int index, final E element) {
        delegate.add(index, element);
    }

    @Override
    protected E doSet(final int index, final E element) {
        return delegate.set(index, element);
    }

    @Override
    protected E doRemove(final int index) {
        return delegate.remove(index);
    }
}