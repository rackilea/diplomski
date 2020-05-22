import java.io.Serializable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Person implements Serializable {

    private StringProperty firstNameProperty    = new SimpleStringProperty();
    private StringProperty lastNameProperty     = new SimpleStringProperty();
    private StringProperty eMailProperty        = new SimpleStringProperty();

    public Person() {
    }

    public Person(final String firstName, final String lastName, final String email) {
        this.firstNameProperty.set(firstName);
        this.lastNameProperty.set(lastName);
        this.eMailProperty.set(email);
    }

    /**
     * @return the firstNameProperty
     */
    public StringProperty getFirstNameProperty() {
        return firstNameProperty;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstNameProperty.get();
    }

    /**
     * @param firstNameProperty the firstNameProperty to set
     */
    public void setFirstNameProperty(StringProperty firstNameProperty) {
        this.firstNameProperty = firstNameProperty;
    }

    /**
     * @return the lastNameProperty
     */
    public StringProperty getLastNameProperty() {
        return lastNameProperty;
    }

    /**
     * @param lastNameProperty the lastNameProperty to set
     */
    public void setLastNameProperty(StringProperty lastNameProperty) {
        this.lastNameProperty = lastNameProperty;
    }

    /**
     * @return the eMailProperty
     */
    public StringProperty geteMailProperty() {
        return eMailProperty;
    }

    /**
     * @param eMailProperty the eMailProperty to set
     */
    public void seteMailProperty(StringProperty eMailProperty) {
        this.eMailProperty = eMailProperty;
    }
}