import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.Window;

public class Main extends Application {

  @Override
  public void start(Stage primaryStage) {
    GridPane grid = new GridPane();
    grid.setPadding(new Insets(20));
    grid.setVgap(15);
    grid.setHgap(15);

    buildGrid(grid, getPanelNames());

    primaryStage.setScene(new Scene(grid));
    primaryStage.setTitle("Example App");
    primaryStage.show();

  }

  private void buildGrid(GridPane grid, List<String> panelNames) {
    int row = 0;
    int col = 0;

    for (String name : panelNames) {
      Label label = new Label(name);
      Button btn = new Button("Click Me!");
      btn.setOnAction(event -> {
        event.consume();
        showAlert(grid.getScene().getWindow(), name);
      });

      VBox box = new VBox(10, label, btn);
      box.setPadding(new Insets(10));
      box.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, null)));
      box.setMinSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);
      grid.add(box, col, row);

      if (++col > 3) {
        col = 0;
        row++;
      }
    }

  }

  private List<String> getPanelNames() {
    return IntStream.rangeClosed(0, 13)
        .mapToObj(i -> "Panel #" + i)
        .collect(Collectors.toList());
  }

  private void showAlert(Window owner, String panelName) {
    Alert alert = new Alert(AlertType.INFORMATION);
    alert.initOwner(owner);
    alert.setTitle(panelName);
    alert.setHeaderText(null);
    alert.setContentText("Hello from \"" + panelName + "\"!");
    alert.show();
  }

}