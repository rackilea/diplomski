private class HasherWrapper<T> {
    T wrappedObject;
    public HasherWrapper(T wrappedObject) {
        this.wrappedObject = wrappedObject;
    }
    @Override
    public int hashCode() {
        // special hash code calculations go here
    }
    @Override
    public boolean equals(Object obj) {
        // special equals code calculations go here
    }
}