public class SimpleUser {
    public final String id;
    public final String name;
    public final String country;

    private SimpleUser(
            final String id,
            final String name,
            final String country) {
        this.id = id;
        this.name = name;
        this.country = countr;
    }

    public static SimpleUser of(
            final String id,
            final String name,
            final String country) {
        return new SimpleUser(id, name, country);
    }
}