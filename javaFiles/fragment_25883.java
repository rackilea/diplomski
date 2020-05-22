import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {
    private final StringProperty id;
    private final StringProperty firstName;
    private final StringProperty lastName;

    private final ObservableList<Account> accounts = FXCollections.observableArrayList();

    public User() {
        this(UUID.randomUUID().toString(), null, null);
    }

    public User(String firstName, String lastName) {
        this(UUID.randomUUID().toString(), firstName, lastName);
    }

    public User(String id, String firstName, String lastName) {
        this.id = new SimpleStringProperty(id);
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
    }

    public String getId() {
        return id.get();
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public StringProperty idProperty() {
        return id;
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public ObservableList<Account> accounts() { return accounts; }

    @XmlElementWrapper(name="accounts")
    @XmlElement(name = "account")
    public List<Account> getAccounts() {
        return new ArrayList<>(accounts);
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts.setAll(accounts);
    }

}