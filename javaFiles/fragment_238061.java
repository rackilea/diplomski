class NonDuplicateList<E> {
    private final List<E> delegate = new ArrayList<>();

    boolean add(E e){
        // contains is easier! ArrayList.contains does not use an iterator.
        if (delegate.contains(e)) return false;
        return delegate.add(e);
    }

    // Other methods you may require
}