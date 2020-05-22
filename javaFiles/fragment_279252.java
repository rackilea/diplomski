static final class TypedList<T> extends AbstractList<T> {
    private final List<T> delegate;
    private final Class<T> type;

    public TypedList(List<T> delegate, Class<T> type) {
        this.delegate = Objects.requireNonNull(delegate);
        this.type = Objects.requireNonNull(type);
    }

    @Override
    public T get(int index) {
        return delegate.get(index);
    }

    @Override
    public int size() {
        return delegate.size();
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        // Lists are equal, now additionally, check the type
        TypedList<?> other = (TypedList<?>) obj;
        return this.type.equals(other.type);
    }

    // hashCode omitted for brevity
}