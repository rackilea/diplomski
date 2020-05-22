package tableview;

import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/** Main application class for tableview fxml demo application */
public class TableViewApplication extends Application {
  public static void main(String[] args) { launch(args); }
  @Override public void start(Stage stage) throws IOException {
    AnchorPane layout = FXMLLoader.load(
      new URL(TableViewApplication.class.getResource("tableview.fxml").toExternalForm())
    );
    stage.setScene(new Scene(layout));
    stage.show();
  }
}