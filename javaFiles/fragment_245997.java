import java.util.function.Function;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TwoTablesDragging extends Application {

    private static final String DRAGGING_PERSON_KEY = "dragging-person";
    private Person currentDraggedPerson ;

    @Override
    public void start(Stage primaryStage) {
        TableView<Person> contacts = createPersonTable();
        TableView<Person> selectedContacts = createPersonTable();
        contacts.getItems().addAll(
                new Person("Jacob", "Smith", "jacob.smith@example.com"),
                new Person("Isabella", "Johnson", "isabella.johnson@example.com"),
                new Person("Ethan", "Williams", "ethan.williams@example.com"),
                new Person("Emma", "Jones", "emma.jones@example.com"),
                new Person("Michael", "Brown", "michael.brown@example.com")
        );
        HBox root = new HBox(10, contacts, selectedContacts);
        root.setPadding(new Insets(10));
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    private void setUpDragAndDrop(TableView<Person> table) {

        // note: It's generally better to set drag detected on the table rows, using
        // a rowFactory, so you don't rely on selection. This is just a "quick and dirty"
        // approach for a demo
        table.setOnDragDetected(e -> {
            Dragboard db = table.startDragAndDrop(TransferMode.COPY_OR_MOVE);
            ClipboardContent content = new ClipboardContent();
            content.putString(DRAGGING_PERSON_KEY);
            db.setContent(content);
            currentDraggedPerson = table.getSelectionModel().getSelectedItem();
        });

        table.setOnDragOver(e -> {
            Dragboard db = e.getDragboard();
            if (DRAGGING_PERSON_KEY.equals(db.getString()) &&
                    ! table.getItems().contains(currentDraggedPerson)) {
                e.acceptTransferModes(TransferMode.MOVE);
            }
        });

        table.setOnDragDropped(e -> {
            Dragboard db = e.getDragboard();
            if (DRAGGING_PERSON_KEY.equals(db.getString())) {
                table.getItems().add(currentDraggedPerson);
                e.setDropCompleted(true);
            } else {
                e.setDropCompleted(false);
            }
        });

        table.setOnDragDone(e -> {
            if (e.getTransferMode() == TransferMode.MOVE) {
                table.getItems().remove(currentDraggedPerson);
                currentDraggedPerson = null ;
            }
        });
    }

    private TableView<Person> createPersonTable() {
        TableView<Person> table = new TableView<>();
        table.getColumns().add(column("First Name", Person::firstNameProperty, 100));
        table.getColumns().add(column("Last Name", Person::lastNameProperty, 100));
        table.getColumns().add(column("Email", Person::emailProperty, 175));
        setUpDragAndDrop(table);
        return table ;
    }

    private <S,T> TableColumn<S,T> column(String title, Function<S, ObservableValue<T>> prop, double width) {
        TableColumn<S,T> col = new TableColumn<>(title);
        col.setCellValueFactory(cellData -> prop.apply(cellData.getValue()));
        col.setPrefWidth(width);
        return col ;
    }

    public static class Person {
        private StringProperty firstName = new SimpleStringProperty();
        private StringProperty lastName = new SimpleStringProperty();
        private StringProperty email = new SimpleStringProperty();

        public Person(String firstName, String lastName, String email) {
            setFirstName(firstName);
            setLastName(lastName);
            setEmail(email);
        }

        public final StringProperty firstNameProperty() {
            return this.firstName;
        }

        public final java.lang.String getFirstName() {
            return this.firstNameProperty().get();
        }

        public final void setFirstName(final java.lang.String firstName) {
            this.firstNameProperty().set(firstName);
        }

        public final StringProperty lastNameProperty() {
            return this.lastName;
        }

        public final java.lang.String getLastName() {
            return this.lastNameProperty().get();
        }

        public final void setLastName(final java.lang.String lastName) {
            this.lastNameProperty().set(lastName);
        }

        public final StringProperty emailProperty() {
            return this.email;
        }

        public final java.lang.String getEmail() {
            return this.emailProperty().get();
        }

        public final void setEmail(final java.lang.String email) {
            this.emailProperty().set(email);
        }


    }

    public static void main(String[] args) {
        launch(args);
    }
}