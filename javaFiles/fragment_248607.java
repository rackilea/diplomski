class Name<E extends Comparable<E>> extends AbstractCollection {

    @Override
    public NameIterator<E> iterator() {
        return new NameIterator<>();
    }

    @Override
    public int size() {
        return 0;
    }
}

class NameIterator<E extends Comparable<E>> implements Iterator{

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public E next() {
        return null;
    }
}