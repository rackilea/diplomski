public final class ObjectWithId<T> {
    private final String id;
    private final T ob;

    public ObjectWithId( String id, T ob ) {
       this.id = id;
       this.ob = ob;
    }

    public String getId() {
       return id;
    }

    public T getObject() {
       return ob;
    }
}