class MyReader<T> {
    private final Class<T> clazz;
    MyReader(Class<T> clazz) {
        if (clazz == null) {
            throw new NullPointerException();
        }
        this.clazz = clazz;
    }
    public T restore(String from) {
        ...
        try {
            restoredItem = clazz.cast(decoder.readObject());
            ...
            return restoredItem;
        } catch (ClassCastException exc) {
            ...
        }
    }
}