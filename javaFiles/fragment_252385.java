public abstract class ProductID{
    private final String id;

    public StringWrapper(String id){
        Preconditions.checkNotNull(id, "Can't construct a ProductID from null");
        Preconditions.checkArgument(isValidId(id), "%s is not a valid Product ID", id);
        this.id = id;
    }

    public String getID(){
        return id;
    }

    public static boolean isValidID(id) {
      // check format
    }

    public boolean equals(Object o) {
        return (o instanceof ProductID && ((ProductID) o).id.equals(this.id));
    }

    public boolean hashCode() {
        return id.hashCode();
    }

    public String toString() {
        return id;
    }
}