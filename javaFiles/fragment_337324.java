class Extensions<E> {
    private final Class<E> type;
    private final List<E>  extensions;

    public Extensions(Class<E> type) {
        this.type       = type;
        this.extensions = App.findExtensions(type);
    }
}