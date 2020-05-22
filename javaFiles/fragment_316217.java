import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class AddItemToComboBox extends Application {

    @Override
    public void start(Stage primaryStage) {
        ComboBox<String> combo = new ComboBox<>();
        combo.getItems().addAll("One", "Two", "Three", "");
        combo.setCellFactory(lv -> {
            ListCell<String> cell = new ListCell<String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setText(null);
                    } else {
                        if (item.isEmpty()) {
                            setText("Add item...");
                        } else {
                            setText(item);
                        }
                    }
                }
            };

            cell.addEventFilter(MouseEvent.MOUSE_PRESSED, evt -> {
                if (cell.getItem().isEmpty() && ! cell.isEmpty()) {
                    TextInputDialog dialog = new TextInputDialog();
                    dialog.setContentText("Enter item");
                    dialog.showAndWait().ifPresent(text -> {
                        int index = combo.getItems().size()-1;
                        combo.getItems().add(index, text);
                        combo.getSelectionModel().select(index);
                    });
                    evt.consume();
                }
            });

            return cell ;
        });

        BorderPane root = new BorderPane();
        root.setTop(combo);
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}