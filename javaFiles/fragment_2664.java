import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Random;

public class TableSortPerformanceTest extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Table View Sample");
        stage.setWidth(550);
        stage.setHeight(550);

        final Label label = new Label("Address Book");
        label.setFont(new Font("Arial", 20));

        final TableView<Person> table = new TableView<Person>();
        table.setEditable(true);

        TableColumn<Person, String> firstNameCol = new TableColumn<Person, String>("First Name");
        firstNameCol.setMinWidth(100);
        firstNameCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("firstName"));
        firstNameCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Person,String>, ObservableValue<String>>() {
          @Override
          public ObservableValue<String> call(CellDataFeatures<Person, String> cdf) {
            return cdf.getValue().firstNameProperty();
          }
        });

        TableColumn<Person, String> lastNameCol = new TableColumn<Person, String>("Last Name");
        lastNameCol.setMinWidth(100);
        lastNameCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("lastName"));



        TableColumn<Person, String> emailCol = new TableColumn<Person, String>("Email");
        emailCol.setMinWidth(200);
        emailCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("email"));


        Random random = new Random();
        for (int i = 0; i < 100000; i++) {
          table.getItems().add(new Person(randomString(random), randomString(random), randomString(random)));
        }
        table.getColumns().addAll(Arrays.asList(firstNameCol, lastNameCol, emailCol));

        long start = new Date().getTime();
        Collections.sort(table.getItems());
        long end   = new Date().getTime();
        System.out.println("Took: " + (end - start));


        final TextField addFirstName = new TextField();
        addFirstName.setPromptText("First Name");
        addFirstName.setMaxWidth(firstNameCol.getPrefWidth());
        final TextField addLastName = new TextField();
        addLastName.setMaxWidth(lastNameCol.getPrefWidth());
        addLastName.setPromptText("Last Name");
        final TextField addEmail = new TextField();
        addEmail.setMaxWidth(emailCol.getPrefWidth());
        addEmail.setPromptText("Email");

        final Button addButton = new Button("Add");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                table.getItems().add(new Person(
                        addFirstName.getText(),
                        addLastName.getText(),
                        addEmail.getText()));
                addFirstName.clear();
                addLastName.clear();
                addEmail.clear();
            }
        });

        final HBox hb = new HBox(3);
        hb.getChildren().addAll(addFirstName, addLastName, addEmail, addButton);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table, hb);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();
    }

    private String randomString(Random random) {
      char[] chars = new char[20];
      for (int i = 0; i < 20; i++) {
        int nextInt = random.nextInt(26);
        nextInt += random.nextBoolean() ? 65 : 97;
        chars[i] = (char) nextInt;
      }
      return new String(chars);
    }

    public static class Person implements Comparable<Person> {

        private final StringProperty firstName;
        private final StringProperty lastName;
        private final StringProperty email;

        private Person(String fName, String lName, String email) {
            this.firstName = new SimpleStringProperty(fName);
            this.lastName = new SimpleStringProperty(lName);
            this.email = new SimpleStringProperty(email);
        }

        public String getFirstName() {
            return firstName.get();
        }

        public void setFirstName(String fName) {
            firstName.set(fName);
        }

        public StringProperty firstNameProperty() {
          return firstName ;
        }

        public String getLastName() {
            return lastName.get();
        }

        public void setLastName(String fName) {
            lastName.set(fName);
        }

        public StringProperty lastNameProperty() {
          return lastName ;
        }

        public String getEmail() {
            return email.get();
        }

        public void setEmail(String fName) {
            email.set(fName);
        }

        public StringProperty emailProperty() {
          return email ;
        }

    @Override
    public int compareTo(Person o) {
      return firstName.get().compareTo(o.getFirstName());
    }
  }
}