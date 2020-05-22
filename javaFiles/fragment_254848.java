public class Account {
    private final int id;
    private final String name;
    private final String description;

    public Account(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int id() {
        return id;
    }

    public String name() {
        return name;
    }

    public String description() {
        return description;
    }
}