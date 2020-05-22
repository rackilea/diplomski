package application;

import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;


public class PersonListController {
    @FXML
    private ListView<Person> personList ;
    @FXML
    private Button editButton ;

    public void initialize() {

        // list created so it fires updates if either the firstName or lastName change:
        ObservableList<Person> people = FXCollections.observableArrayList(person -> 
            new Observable[] {person.firstNameProperty(), person.lastNameProperty()});

        people.addAll(new Person("Jacob", "Smith"),
                new Person("Isabella", "Johnson"),
                new Person("Ethan", "Williams"),
                new Person("Emma", "Jones"),
                new Person("Michael", "Johnson"));
        personList.setItems(people);

        editButton.disableProperty().bind(
                Bindings.isNull(personList.getSelectionModel().selectedItemProperty()));
    }

    @FXML
    private void newPerson() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PersonEditor.fxml"));
        Parent root = loader.load();

        PersonEditorController controller = loader.getController();
        controller.personProperty().addListener((obs, oldPerson, newPerson) -> {
            if (newPerson != null) {
                personList.getItems().add(newPerson);
            }
        });

        showEditorWindow(root);
    }


    @FXML
    private void editPerson() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PersonEditor.fxml"));
        Parent root = loader.load();

        PersonEditorController controller = loader.getController();
        controller.setPerson(personList.getSelectionModel().getSelectedItem());

        showEditorWindow(root);
    }

    private void showEditorWindow(Parent root) {
        Scene scene = new Scene(root, 350, 200);
        Stage stage = new Stage();
        stage.initOwner(personList.getScene().getWindow());
        stage.setScene(scene);
        stage.show();
    }

}