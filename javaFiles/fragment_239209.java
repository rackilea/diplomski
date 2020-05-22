public abstract class ImmutableList<T> implements Iterable<T> {
    /**
     * Adds an element to the head of the list, returning the new list.
     *
     * @param o The element to be added to the list.
     * @return The list consisting of the element <var>o</var> followed by
     *         this list.
     */
    public final ImmutableList<T> add(final T o) {
        return new Node<>(o, this);
    }

    /**
     * Removes the element <var>o</var> resulting in a new list which
     * is returned to the caller.
     *
     * @param o The object to be removed from the list.
     * @return A list consisting of this list with object <var>o</var> removed.
     */
    public abstract ImmutableList<T> remove(final T o);

    public abstract boolean isEmpty();
    public abstract int size();

    public abstract boolean contains(final T o);

    private ImmutableList() {}

    /**
     * Returns a "standard" enumeration over the elements of the list.
     */
    public Iterator<T> iterator() {
        return new NodeIterator<>(this);
    }

    /**
     * The empty list.  Variables of type ImmutableList should be
     * initialised to this value to create new empty lists.
     */
    private static final ImmutableList<?> EMPTY = new ImmutableList<Object>() {
        @Override
        public ImmutableList<Object> remove(final Object o) {
            return this;
        }

        @Override
        public boolean isEmpty() {
            return true;
        }

        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean contains(final Object o) {
            return false;
        }
    };

    @SuppressWarnings("unchecked")
    public static <T> ImmutableList<T> empty() {
        return (ImmutableList<T>)EMPTY;
    }

    public static <T> ImmutableList<T> create(final T head) {
        return new Node<>(head, ImmutableList.<T>empty());
    }

    static class Node<T> extends ImmutableList<T> {
        private final int _size;

        private Node(final T element, final ImmutableList<T> next) {
            _element = element;
            _next = ArgumentHelper.verifyNotNull(next, "next");
            _size = next.size() + 1;
        }

        public ImmutableList<T> remove(final T old) {
            if (_element == old) {
                return _next;
            }
            else {
                final ImmutableList<T> n = _next.remove(old);
                if (n == _next) {
                    return this;
                }
                else {
                    return new Node<>(_element, n);
                }
            }
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public int size() {
            return _size;
        }

        @Override
        public boolean contains(final T o) {
            return Objects.equals(_element, o) || _next.contains(o);
        }

        private final T _element;
        private final ImmutableList<T> _next;
    }

    private class NodeIterator<T> implements Iterator<T> {
        private ImmutableList<T> _current;

        private NodeIterator(final ImmutableList<T> head) {
            _current = ArgumentHelper.verifyNotNull(head, "head");
        }

        public boolean hasNext() {
            return !_current.isEmpty();
        }

        public T next() {
            final T result = ((Node<T>)_current)._element;
            _current = ((Node<T>)_current)._next;
            return result;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}