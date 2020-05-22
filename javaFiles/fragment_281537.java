import javafx.application.Application;
import javafx.collections.ListChangeListener;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class TableTest extends Application {

  public static void main(String[] args) {
      launch(args);
  }

  @Override
  public void start(Stage stage) {
    final TableView tableView = new TableView();
    final TableColumn[] columns = {new TableColumn("1"), new TableColumn("2")};
    tableView.getColumns().setAll(columns);
    tableView.getColumns().addListener(new ListChangeListener() {
        public boolean suspended;

        @Override
        public void onChanged(Change change) {
            change.next();
            if (change.wasReplaced() && !suspended) {
                this.suspended = true;
                tableView.getColumns().setAll(columns);
                this.suspended = false;
            }
        }
    });
    stage.setScene(new Scene(tableView));
    stage.show();
  }
}