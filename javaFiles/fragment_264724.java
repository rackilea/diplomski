public class Person {
    private String name;
    private int age;

    public boolean equals(Object object) {
        // Basic checks.
        if (object == this) return true;
        if (object == null || getClass() != object.getClass()) return false;

        // Property checks.
        Person other = (Person) object;
        if (name == null ? other.name != null : !name.equals(other.name)) return false;
        if (age != other.age) return false;

        // All passed.
        return true;
    }
}