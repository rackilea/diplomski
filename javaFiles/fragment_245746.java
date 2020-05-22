inspect(new Iterable<SomeObject>() {
    @Override
    public Iterator<SomeObject> iterator() {
        throw new UnsupportedOperationException();
    }
});