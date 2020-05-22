import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.MapChangeListener.Change;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MapTableBindTest extends Application {

    int personIDCounter;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        personIDCounter = 0;
        // Map - TableView binding
        ObservableMap<Integer, Person> map = FXCollections.observableHashMap();

        Person first = new Person("First", "Person");   // this person is mapped before the bind to the table
        map.put(first.getID(), first);                  // and because that, is shown on it

        ObservableList<Person> list = FXCollections.observableArrayList(map.values());
        TableView<Person> table = new TableView<>(list);

        map.addListener((Change<? extends Integer, ? extends Person> c) -> {
            if (c.wasAdded()) {
                list.add(c.getValueAdded());
            } else if (c.wasRemoved()) {
                list.remove(c.getValueRemoved());
            }
        });

        Person second = new Person("Second", "Person"); // once the bind has been setted no new items
        map.put(second.getID(), second);                // are shown on the table. Same case when added in the UI

        // Columns
        TableColumn<Person, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(cellData -> cellData.getValue().getName());
        TableColumn<Person, String> lastNameCol = new TableColumn<>("Surname");
        lastNameCol.setCellValueFactory(cellData -> cellData.getValue().getSurname());
        table.getColumns().addAll(nameCol, lastNameCol);

        // View
        BorderPane root = new BorderPane();
        TextField nameField = new TextField();
        TextField lastNameField = new TextField();
        Button addButton = new Button("Add");
        addButton.setOnMouseClicked(event -> {
            Person newP = new Person(nameField.getText(), lastNameField.getText());
            map.put(newP.getID(), newP);    // new items are not populated in the table...
            nameField.clear();
            lastNameField.clear();
        });
        HBox TextHB = new HBox(nameField, lastNameField, addButton);
        root.setTop(TextHB);
        root.setCenter(table);

        Scene scene = new Scene(root,400,500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Sample class with some properties
    class Person {

        private int id;
        private StringProperty name, surname;

        public Person(String name, String surname) {
            id = personIDCounter++;
            this.name = new SimpleStringProperty(name);
            this.surname = new SimpleStringProperty(surname);
        }

        public int getID() {
            return id;
        }

        public StringProperty getName() {
            return name;
        }

        public StringProperty getSurname() {
            return surname;
        }
    }
}