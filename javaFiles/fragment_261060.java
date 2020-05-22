import java.beans.ConstructorProperties;

public class User {
    int id;
    String name;

    // required default constructor
    public User() {
        super();
    }

    @ConstructorProperties({ "id", "name" })
    public User(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    // getter, setter, hashCode, equals, toString
}