public abstract class ObjectWithId {
    private final String id;

    public ObjectWithId( String id ) {
       this.id = id;
    }

    public final String getId() {
       return id;
    }
}