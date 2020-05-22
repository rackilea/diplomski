import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TreeViewCellApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        TreeItem<Employee> leaf1Item = new TreeItem<Employee>(new Employee("Anne Burnes", "Employee"));
        TreeItem<Employee> leaf2Item = new TreeItem<Employee>(new Employee("Ronan Jackson", "Employee"));

        TreeItem<Employee> rootItem = new TreeItem<Employee>(new Employee("Jack Shields", "Head"));
        rootItem.getChildren().add(leaf1Item);
        rootItem.getChildren().add(leaf2Item);

        Label label = new Label();

        TreeView<Employee> treeView = new TreeView<>(rootItem);
        treeView.setCellFactory(param -> new TreeCell<Employee>() {
            @Override
            protected void updateItem(Employee employee, boolean empty) {
                super.updateItem(employee, empty);
                if (employee == null || empty) {
                    setGraphic(null);
                } else {
                    EmployeeControl employeeControl = new EmployeeControl(employee);
                    employeeControl.setOnMouseClicked(mouseEvent -> label.setText(employee.getName()));
                    setGraphic(employeeControl);
                }
            }
        });

        VBox vBox = new VBox(label, treeView);

        stage.setScene(new Scene(vBox));
        stage.show();
    }
}

class Employee {

    private final String name;
    private final String capacity;

    public Employee(String name, String capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public String getCapacity() {
        return capacity;
    }
}

class EmployeeControl extends HBox {

    private final Label nameLabel = new Label();
    private final Label capacityLabel = new Label();

    {
        getChildren().addAll(nameLabel, capacityLabel);
    }

    public EmployeeControl(Employee employee) {
        nameLabel.setText(employee.getName());
        capacityLabel.setText(employee.getCapacity());
    }
}