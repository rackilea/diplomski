private static class UnremovableList<E> implements  List<E> {
    private List<E> innerContainer;

    public UnremovableList(List<E> original) {
        innerContainer = original
    }

    @Override
    public void add(int location, E object) {
        innerContainer.add(location, object);
    }

    @Override
    public boolean add(E object) {
        return innerContainer.add(object);
    }

    @Override
    public boolean addAll(int location, Collection<? extends E> collection) {
        return innerContainer.addAll(location, collection);
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        return innerContainer.addAll(collection);
    } - 

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean contains(Object object) {
        return innerContainer.contains(object);
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        return innerContainer.containsAll(collection);
    }

    @Override
    public E get(int location) {
        return innerContainer.get(location);
    }

    @Override
    public int indexOf(Object object) {
        return innerContainer.indexOf(object);
    }

    @Override
    public boolean isEmpty() {
        return innerContainer.isEmpty();
    }

    @NonNull
    @Override
    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    @NonNull
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Iterator<E> iterator = innerContainer.iterator();

            @Override public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override public E next() {
                return iterator.next();
            }

            @Override public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override
    public ListIterator<E> listIterator(final int location) {
        return new ListIterator<E>() {
            ListIterator<E> iterator = innerContainer.listIterator(location);

            @Override public void add(E object) {
                throw new UnsupportedOperationException();
            }

            @Override public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override public boolean hasPrevious() {
                return iterator.hasPrevious();
            }

            @Override public E next() {
                return iterator.next();
            }

            @Override public int nextIndex() {
                return iterator.nextIndex();
            }

            @Override public E previous() {
                return iterator.previous();
            }

            @Override public int previousIndex() {
                return iterator.previousIndex();
            }

            @Override public void remove() {
                throw new UnsupportedOperationException();
            }

            @Override public void set(E object) {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override
    public int lastIndexOf(Object object) {
        return innerContainer.lastIndexOf(object);
    }

    @Override
    public E remove(int location) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public E set(int location, E object) {
        return innerContainer.set(location, object);
    }

    @Override
    public int size() {
        return innerContainer.size();
    }

    @NonNull
    @Override
    public List<E> subList(int start, int end) {
        return new UnremovableList(innerContainer.subList(start, end));
    }

    @NonNull
    @Override
    public Object[] toArray() {
        return innerContainer.toArray();
    }

    @NonNull
    @Override
    public <T> T[] toArray(T[] array) {
        return innerContainer.toArray(array);
    }
}