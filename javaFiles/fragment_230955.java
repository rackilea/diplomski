public class Person {

    private boolean hasChanged = false;

    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public boolean hasChanged() {
        return hasChanged;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String value) {
        if (value == null ? firstName != null : !value.equals(firstName)) {
            firstName = value;
            hasChanged = true;
        }
    }

    public void setLastName(String value) {
        if (value == null ? lastName != null : !value.equals(lastName)) {
            lastName = value;
            hasChanged = true;
        }
    }
}