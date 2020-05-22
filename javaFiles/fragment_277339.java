package tablerowcolor;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TableRowColor extends Application {

  @Override
  public void start(Stage primaryStage) {
    ObservableList<Person> persons
            = FXCollections.observableArrayList(
                    new Person("Sir", "Tobey"),
                    new Person("Admiral", "von Schneider"),
                    new Person("Mr.", "Pommeroy"),
                    new Person("Mr.", "Winterbottom"));

    TableView<Person> tableView = new TableView<>(persons);
    tableView.
            setStyle("-fx-selection-bar: red; -fx-selection-bar-non-focused: salmon;");

    TableColumn<Person, String> firstNameCol = new TableColumn<>("First Name");
    firstNameCol.setCellValueFactory(new PropertyValueFactory("firstName"));
    TableColumn<Person, String> lastNameCol = new TableColumn<>("Last Name");
    lastNameCol.setCellValueFactory(new PropertyValueFactory("lastName"));

    tableView.getSelectionModel().clearAndSelect(0);
    tableView.getColumns().setAll(firstNameCol, lastNameCol);

    Button btn = new Button();
    btn.setText("Focus me");

    VBox root = new VBox();
    root.getChildren().addAll(tableView, btn);

    Scene scene = new Scene(root, 300, 250);

    primaryStage.setTitle("Selection Row Color");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    launch(args);
  }

  public class Person {

    private final StringProperty firstName
            = new SimpleStringProperty(this, "firstName");

    public void setFirstName(String value) {
      firstNameProperty().set(value);
    }

    public String getFirstName() {
      return firstNameProperty().get();
    }

    public StringProperty firstNameProperty() {
      return firstName;
    }

    private final StringProperty lastName
            = new SimpleStringProperty(this, "lastName");

    ;

    public void setLastName(String value) {
      lastNameProperty().set(value);
    }

    public String getLastName() {
      return lastNameProperty().get();
    }

    public StringProperty lastNameProperty() {
      return lastName;
    }

    public Person(String firstName, String lastName) {
      this.firstName.set(firstName);
      this.lastName.set(lastName);
    }
  }
}