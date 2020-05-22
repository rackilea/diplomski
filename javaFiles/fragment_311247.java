import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class TableWithButtonHeaders extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        TableColumn firstNameCol = new TableColumn("First Name");
        addHeaderButtons(firstNameCol);
        firstNameCol.setPrefWidth(160);
        firstNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));

        TableColumn lastNameCol = new TableColumn("Last Name");
        lastNameCol.setPrefWidth(100);
        lastNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));


        TableView table = new TableView();
        table.getColumns().addAll(firstNameCol, lastNameCol);
        table.setItems(FXCollections.observableArrayList(
                new Person("Jacob", "Smith"),
                new Person("Isabella", "Johnson"),
                new Person("Ethan", "Williams")
        ));
        table.setPrefSize(300, 200);


        Pane layout = new VBox(10);
        layout.setStyle("-fx-padding: 10;");
        layout.getChildren().addAll(table);
        stage.setScene(new Scene(layout));

        stage.getScene().getStylesheets().add(
                TableWithButtonHeaders.class.getResource(
                        "alignment.css"
                ).toExternalForm()
        );

        stage.show();
    }

    private void addHeaderButtons(TableColumn col) {
        Label label = new Label(col.getText());
        label.setStyle("-fx-padding: 5px;");
        HBox hBox = new HBox(new Button("X"), label, new Button("X"));
        hBox.setMinWidth(Control.USE_PREF_SIZE);

        Rectangle clip = new Rectangle(0,0, col.getWidth(), hBox.getHeight());
        col.widthProperty().addListener(observable -> clip.setWidth(col.getWidth()));
        hBox.heightProperty().addListener(observable -> clip.setHeight(hBox.getHeight()));
        hBox.setClip(clip);

        col.getStyleClass().add("buttontastic");
        col.setText(null);
        col.setGraphic(hBox);
    }

    public static class Person {
        private final SimpleStringProperty firstName;
        private final SimpleStringProperty lastName;

        private Person(String fName, String lName) {
            this.firstName = new SimpleStringProperty(fName);
            this.lastName = new SimpleStringProperty(lName);
        }

        public String getFirstName() {
            return firstName.get();
        }

        public void setFirstName(String fName) {
            firstName.set(fName);
        }

        public String getLastName() {
            return lastName.get();
        }

        public void setLastName(String fName) {
            lastName.set(fName);
        }
    }
}