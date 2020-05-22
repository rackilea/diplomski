import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        // Simple interface
        VBox root = new VBox(5);
        root.setPadding(new Insets(10));
        root.setAlignment(Pos.CENTER);

        // Simple TableView
        TableView<Item> tableView = new TableView<>();
        TableColumn<Item, String> colName = new TableColumn<>("Name");
        TableColumn<Item, Number> colQuantity = new TableColumn<>("Quantity");
        // Since IntegerProperty implements ObservableValue<Number> instead of Integer, for some reason, we need
        // to change our column definition to accept that

        // Set the cell value factories
        colName.setCellValueFactory(c -> c.getValue().nameProperty());
        colQuantity.setCellValueFactory(c -> c.getValue().quantityProperty());

        // Override the CellFactory for quantity to leave empty if value is 9
        colQuantity.setCellFactory(param -> new TableCell<Item, Number>() {
            @Override
            protected void updateItem(Number itemQuantity, boolean empty) {
                super.updateItem(itemQuantity, empty);
                if (empty || itemQuantity.equals(0)) {
                    // If the item's quantity is 0, set the cell to display nothing (null)
                    setText(null);
                } else {
                    // Otherwise, the cell should display a label with the value of the item's quantity
                    setText(itemQuantity.toString());

                }
            }
        });

        // Add the columns to the TableView
        tableView.getColumns().addAll(colName, colQuantity);

        // Populate the table with sample items
        tableView.getItems().setAll(
                new Item("Tools", 3),
                new Item("Saws", 0),
                new Item("Ruler", 2)
        );

        root.getChildren().add(tableView);

        // Show the Stage
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}