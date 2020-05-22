public class DbObject {

    private String id;

    public DbObject(String id) {
        this.id = id;
    }

    public static DbObject valueOf(String id) {
        return new DbObject(id);
    }

    ...
}