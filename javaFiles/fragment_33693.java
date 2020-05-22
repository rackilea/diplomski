package application;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class PersonEditorController {
    @FXML
    private TextField firstNameTF ;
    @FXML
    private TextField lastNameTF ;

    private final ObjectProperty<Person> person = new SimpleObjectProperty<>();

    public ObjectProperty<Person> personProperty() {
        return person;
    }
    public final Person getPerson() {
        return personProperty().get();
    }
    public final void setPerson(Person person) {
        personProperty().set(person);
    }

    public void initialize() {
        personProperty().addListener((obs, oldPerson, newPerson) -> {
            if (newPerson != null) {
                firstNameTF.setText(newPerson.getFirstName());
                lastNameTF.setText(newPerson.getLastName());
            }
        });
    }

    @FXML
    private void submit() {
        if (person.get() == null) {
            person.set(new Person(firstNameTF.getText(), lastNameTF.getText()));
        } else {
            person.get().setFirstName(firstNameTF.getText());
            person.get().setLastName(lastNameTF.getText());
        }
        close();
    }

    @FXML
    private void cancel() {
        close();
    }

    private void close() {
        firstNameTF.getScene().getWindow().hide();
    }
}