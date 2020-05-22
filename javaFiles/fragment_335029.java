import java.util.HashMap;
import java.util.Map;

class User {
    private Map<String, MyObject> user = new HashMap<String, MyObject>();

    public Map<String, MyObject> getUser() {
        return user;
    }

    public void setUser(Map<String, MyObject> user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "User{" +
                "user=" + user +
                '}';
    }
}

class MyObject {
    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "MyObject{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}