public interface Animal {}

public enum Dog implements Animal {
    HUSKY("Husky"), LAB("Labrador");

    private final String name;

    Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}