import javafx.application.Application;
import javafx.collections.*;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ReadOnlyTableView extends Application {
  private TableView<Person> table = new TableView<Person>();
  private final ObservableList<Person> data =
    FXCollections.observableArrayList(
      new Person("Jacob", "Smith", "jacob.smith@example.com"),
      new Person("Isabella", "Johnson", "isabella.johnson@example.com"),
      new Person("Ethan", "Williams", "ethan.williams@example.com"),
      new Person("Emma", "Jones", "emma.jones@example.com"),
      new Person("Michael", "Brown", "michael.brown@example.com")
    );

  public static void main(String[] args) { launch(args); }

  @Override public void start(Stage stage) {
    stage.setTitle("Table View Sample");
    stage.setWidth(450);
    stage.setHeight(500);

    final Label label = new Label("Address Book");
    label.setFont(new Font("Arial", 20));

    TableColumn firstNameCol = new TableColumn("First Name");
    firstNameCol.setMinWidth(100);
    firstNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));

    TableColumn lastNameCol = new TableColumn("Last Name");
    lastNameCol.setMinWidth(100);
    lastNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));

    TableColumn emailCol = new TableColumn("Email");
    emailCol.setMinWidth(200);
    emailCol.setCellValueFactory(new PropertyValueFactory<Person, String>("email"));

    table.setItems(data);
    table.getColumns().addAll(firstNameCol, lastNameCol, emailCol);

    final VBox vbox = new VBox();
    vbox.setSpacing(5);
    vbox.setPadding(new Insets(10, 0, 0, 10));
    vbox.getChildren().addAll(label, table);

    stage.setScene(new Scene(new Group(vbox)));
    stage.show();
  }

  public static class Person {
    private String firstName;
    private String lastName;
    private String email;

    private Person(String fName, String lName, String email) {
      this.firstName = fName;
      this.lastName = lName;
      this.email = email;
    }

    public String getFirstName() { return firstName; }
    public void setFirstName(String fName) { firstName = fName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lName) { lastName = lName; }
    public String getEmail() { return email; }
    public void setEmail(String inMail) { email = inMail; }
  }
}