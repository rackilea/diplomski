public class Kunde {

    // Properties:

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

    // similarly for other properties

    // Constructor:

    public Kunde(String firstName /* , ... */) {
        // Note there is no problem in calling setFirstName(...)
        // from the constructor as it is a final method:
        setFirstName(firstName);

        // ...
    }

}