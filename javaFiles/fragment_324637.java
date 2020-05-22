public class Person {

    private final StringProperty firstName = new SimpleStringProperty();

    public StringProperty firstNameProperty() {
        return firstName ;
    }

    public final String getFirstName() {
        return firstNameProperty().get();
    }

    public final void setFirstName(String firstName) {
        firstNameProperty().set(firstName);
    }
}