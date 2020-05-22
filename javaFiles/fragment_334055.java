import java.util.function.Function;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class HighlightTableRows extends Application {

    @Override
    public void start(Stage primaryStage) {


        TableView<Person> table = new TableView<>();
        table.getColumns().add(column("First Name", Person::firstNameProperty));
        table.getColumns().add(column("Last Name", Person::lastNameProperty));

        for (int i = 1 ; i <=50 ; i++) {
            table.getItems().add(new Person("Person"+i, "McPerson"+i));
        }

        ObjectProperty<Person> criticalPerson = new SimpleObjectProperty<>();


        table.setRowFactory(tv -> {
            TableRow<Person> row = new TableRow<>();
            BooleanBinding critical = row.itemProperty().isEqualTo(criticalPerson).and(row.itemProperty().isNotNull());
            row.styleProperty().bind(Bindings.when(critical)
                .then("-fx-background-color: red ;")
                .otherwise(""));
            return row ;
        });

        BorderPane root = new BorderPane(table);

        Button apply = new Button("Make critical");
        apply.setOnAction(e -> criticalPerson.set(table.getSelectionModel().getSelectedItem()));
        apply.disableProperty().bind(table.getSelectionModel().selectedItemProperty().isNull());
        Button clear = new Button("Clear");
        clear.setOnAction(e -> criticalPerson.set(null));

        HBox controls = new HBox(5, apply, clear);
        controls.setAlignment(Pos.CENTER);
        controls.setPadding(new Insets(5));
        root.setBottom(controls);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private <S,T> TableColumn<S,T> column(String text, Function<S, ObservableValue<T>> prop) {
        TableColumn<S,T> col = new TableColumn<>(text);
        col.setCellValueFactory(cellData -> prop.apply(cellData.getValue()));
        return col ;
    }

    public class Person {

        private final StringProperty firstName;
        private final StringProperty lastName;

        /**
         * Default constructor.
         */
        public Person() {
            this(null, null);
        }

        /**
         * Constructor with some initial data.
         * 
         * @param firstName
         * @param lastName
         */
        public Person(String firstName, String lastName) {
            this.firstName = new SimpleStringProperty(firstName);
            this.lastName = new SimpleStringProperty(lastName);
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

    }

    public static void main(String[] args) {
        launch(args);
    }
}