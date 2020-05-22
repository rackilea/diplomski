public class MyMap<T> extends AbstractMap<T,T> {
    private Map<T,T> delegate;

    public MyMap(Map<T,T> delegate) {
        this.delegate = Objects.requireNonNull(delegate);
    }

    public Set<Map.Entry<T,T>> entrySet() {
        return delegate.entrySet();
    }

    // Optionally, implement other Map methods by calling the same methods
    // on delegate.

    public T f(T o) {
        // ...
    }
}