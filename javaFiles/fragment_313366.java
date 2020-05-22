public class Person {
    private final StringProperty firstName 
        = new SimpleStringProperty(this, "firstName");

    public final String getFirstName() {
        return firstName.get();
    }

    public final void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public StringProperty firstNameProperty() {
        return firstName ;
    }

    // ... other properties, etc
}