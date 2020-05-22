import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class Controller {

  @FXML
  private TableView<Object> table; // Using <Object> for example

  @FXML
  private void initialize() {
    EventHandler<MouseEvent> onClick = this::handleTableRowMouseClick;
    table.setRowFactory(param -> {
      TableRow<Object> row = new TableRow<>();
      row.setOnMouseClicked(onClick);
      return row;
    });
  }

  private void handleTableRowMouseClick(MouseEvent event) {
    if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {

      // We know it will be a TableRow<Object> since that is the only kind
      // of object we added the EventHandler to.
      @SuppressWarnings("unchecked")
      TableRow<Object> row = (TableRow<Object>) event.getSource();

      if (!row.isEmpty() && row.getItem() != null) {
        displayItem(row.getItem());
        event.consume();
      }
    }
  }

  private void displayItem(Object item) {
    // This is where you'd put your code that opens the item in
    // its own Stage.
  }

}