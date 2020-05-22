import javafx.application.Application;
import javafx.beans.property.*;
import javafx.collections.*;
import javafx.event.*;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class PropertyBasedTableView extends Application {
  private TableView<Person> table = new TableView<Person>();
  private final ObservableList<Person> data = FXCollections.observableArrayList();
  private void initData() {
    data.setAll(
      new Person("Jacob", "Smith", "jacob.smith@example.com"),
      new Person("Isabella", "Johnson", "isabella.johnson@example.com"),
      new Person("Ethan", "Williams", "ethan.williams@example.com"),
      new Person("Emma", "Jones", "emma.jones@example.com"),
      new Person("Michael", "Brown", "michael.brown@example.com")
    );
  }

  public static void main(String[] args) { launch(args); }

  @Override public void start(Stage stage) {
    initData();

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
    table.setPrefHeight(300);

    final Button setEmailButton = new Button("Set first email in table to wizard@frobozz.com");
    setEmailButton.setOnAction(new EventHandler<ActionEvent>() {
      @Override public void handle(ActionEvent event) {
        if (data.size() > 0) {
          data.get(0).setEmail("wizard@frobozz.com");
        }  
      }
    });

    final Button removeRowButton = new Button("Remove first row from the table");
    removeRowButton.setOnAction(new EventHandler<ActionEvent>() {
      @Override public void handle(ActionEvent event) {
        if (data.size() > 0) {
          data.remove(0);
        }  
      }
    });

    final Button resetButton = new Button("Reset table data");
    resetButton.setOnAction(new EventHandler<ActionEvent>() {
      @Override public void handle(ActionEvent event) {
        initData();
      }
    });

    final VBox vbox = new VBox(10);
    vbox.setPadding(new Insets(10, 0, 0, 10));
    vbox.getChildren().addAll(label, table, setEmailButton, removeRowButton, resetButton);

    stage.setScene(new Scene(new Group(vbox)));
    stage.show();
  }

  public static class Person {
    private final StringProperty firstName;
    private final StringProperty lastName;
    private final StringProperty email;

    private Person(String fName, String lName, String email) {
      this.firstName = new SimpleStringProperty(fName);
      this.lastName = new SimpleStringProperty(lName);
      this.email = new SimpleStringProperty(email);
    }

    public String getFirstName() { return firstName.get(); }
    public void setFirstName(String fName) { firstName.set(fName); }
    public StringProperty firstNameProperty() { return firstName; }
    public String getLastName() { return lastName.get(); }
    public void setLastName(String lName) { lastName.set(lName); }
    public StringProperty lastNameProperty() { return lastName; }
    public String getEmail() { return email.get(); }
    public void setEmail(String inMail) { email.set(inMail); }
    public StringProperty emailProperty() { return email; }  // if this method is commented out then the tableview will not refresh when the email is set.
  }
}