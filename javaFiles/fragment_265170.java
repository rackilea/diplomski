import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TableViewViaInterface extends Application {

    private TableView<TableEntry> table ;

    @Override
    public void start(Stage primaryStage) {
        table = new TableView<>();
        BorderPane root = new BorderPane(table);
        Button showPersonTable = new Button("Person table");
        showPersonTable.setOnAction(e -> showPersonTable());
        Button showAddressTable = new Button("Address table");
        showAddressTable.setOnAction(e -> showAddressTable());

        HBox buttons = new HBox(5, showPersonTable, showAddressTable);
        buttons.setAlignment(Pos.CENTER);
        buttons.setPadding(new Insets(5));
        root.setBottom(buttons);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showPersonTable() {
        table.getColumns().clear();
        TableColumn<TableEntry, String> firstNameCol = new TableColumn<>("First Name");
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        table.getColumns().add(firstNameCol);

        TableColumn<TableEntry, String> lastNameCol = new TableColumn<>("Last Name");
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        table.getColumns().add(lastNameCol);

        // populate table...
    }

    private void showAddressTable() {
        table.getColumns().clear();
        TableColumn<TableEntry, String> streetCol = new TableColumn<>("Street");
        streetCol.setCellValueFactory(new PropertyValueFactory<>("street"));
        table.getColumns().add(streetCol);

        TableColumn<TableEntry, String> cityCol = new TableColumn<>("City");
        cityCol.setCellValueFactory(new PropertyValueFactory<>("city"));
        table.getColumns().add(cityCol);

        // populate table...

    }

    public interface TableEntry {}
    public class Person implements TableEntry {
        private final StringProperty firstName = new SimpleStringProperty();
        private final StringProperty lastName = new SimpleStringProperty();
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

    }

    public class Address implements TableEntry {
        private final StringProperty street = new SimpleStringProperty();
        private final StringProperty city = new SimpleStringProperty();
        public final StringProperty streetProperty() {
            return this.street;
        }

        public final java.lang.String getStreet() {
            return this.streetProperty().get();
        }

        public final void setStreet(final java.lang.String street) {
            this.streetProperty().set(street);
        }

        public final StringProperty cityProperty() {
            return this.city;
        }

        public final java.lang.String getCity() {
            return this.cityProperty().get();
        }

        public final void setCity(final java.lang.String city) {
            this.cityProperty().set(city);
        }



    }

    public static void main(String[] args) {
        launch(args);
    }
}