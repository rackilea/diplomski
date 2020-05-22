import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SSCCE extends Application {

    @Override
    public void start(Stage stage) {

        VBox root = new VBox();

        TableView<Student> studentsTable = new TableView<Student>();

        HBox studentBox = new HBox();
        Label studentHeader = new Label("Student: ");
        Label studentInfo = new Label("");
        studentBox.getChildren().addAll(studentHeader, studentInfo);

        root.getChildren().addAll(studentsTable, studentBox);

        // Prepare the columns
        TableColumn<Student, String> firstNameCol = new TableColumn<Student, String>(
                "First name");
        firstNameCol.setCellValueFactory(cellData -> cellData.getValue()
                .firstNameProperty());

        TableColumn<Student, String> lastNameCol = new TableColumn<Student, String>(
                "Last name");
        lastNameCol.setCellValueFactory(cellData -> cellData.getValue()
                .lastNameProperty());

        studentsTable.getSelectionModel().selectedItemProperty()
                .addListener(new ChangeListener<Student>() {

                    // Here's the key part. See how I specify that the
                    // parameters are of type student. Now you can use the
                    // instance methods from Student.
                    @Override
                    public void changed(
                            ObservableValue<? extends Student> observable,
                            Student oldValue, Student newValue ) {

                        studentInfo.setText(newValue.getFirstName() + " "
                                + newValue.getLastName());
                        // If you want to get the value of a selected student cell at
                        // anytime, even if it hasn't changed. Just do e.g.
                        // studentsTable.getSelectionModel().getSelectedItem().getFirstName()
                    }
                });

        studentsTable.getColumns().setAll(firstNameCol, lastNameCol);

        // Some mock Student objects
        Student student1 = new Student("Eric", "Smith");
        Student student2 = new Student("Brad", "Jones");
        Student student3 = new Student("Logan", "Thorpe");

        // Fill the table with students.
        studentsTable.getItems().addAll(student1, student2, student3);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    // The student class. In this case an inner class to simplify the example. But generally you should never use inner classes.
    class Student {

        private StringProperty firstName;
        private StringProperty lastName;

        public Student(String firstName, String lastName) {
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

}