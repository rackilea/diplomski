import javafx.application.Application;
    import javafx.beans.property.SimpleStringProperty;
    import javafx.beans.property.StringProperty;
    import javafx.beans.value.ChangeListener;
    import javafx.collections.FXCollections;
    import javafx.collections.ObservableList;
    import javafx.scene.Scene;
    import javafx.scene.control.TableCell;
    import javafx.scene.control.TableColumn;
    import javafx.scene.control.TableView;
    import javafx.scene.control.TextField;
    import javafx.scene.layout.HBox;
    import javafx.scene.layout.Priority;
    import javafx.stage.Stage;

    public class TableViewApp extends Application {

        public static void main(String[] args) {
            launch(args);
        }

        @Override
        public void start(Stage stage) throws Exception {

            ObservableList<Employee> employees = FXCollections.observableArrayList(new Employee("John"), new Employee("Michael"));

            TableView<Employee> tableView = new TableView<>(employees);

            TableColumn<Employee, String> nameColumn = new TableColumn<>("Name");
            nameColumn.setCellFactory(param -> new TableCell<Employee, String>() {

                private final EmployeeNameCell employeeNameCell = new EmployeeNameCell();

                @Override
                protected void updateItem(String name, boolean empty) {
                    super.updateItem(name, empty);
                    if (name == null || empty) {
                        setGraphic(null);
                    } else {
                        employeeNameCell.setName(name);
                        setGraphic(employeeNameCell);
                    }
                }
            });

            nameColumn.setCellValueFactory(param -> param.getValue().nameProperty());

            tableView.getColumns().add(nameColumn);
            Scene scene = new Scene(tableView);
            stage.setScene(scene);
            stage.show();
        }
    }

    class Employee {

        private final StringProperty nameProperty = new SimpleStringProperty();

        public Employee(String name) {
            nameProperty.set(name);
        }

        public StringProperty nameProperty() {
            return nameProperty;
        }
    }

    class EmployeeNameCell extends HBox {

        private final TextField textField = new TextField();

        private final StringProperty nameProperty = new SimpleStringProperty();

        public EmployeeNameCell() {
            getChildren().add(textField);
            setMaxWidth(10e6);
            setHgrow(textField, Priority.ALWAYS);

            nameProperty.addListener((ChangeListener<String>) (observable, oldValue, newValue) -> {
                textField.setText(newValue);
            });
        }

        public void setName(String name) {
            nameProperty.set(name);
        }
    }