import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JavaFXApplication2 extends Application {

  @Override
  public void start(Stage stage) throws Exception {
    URL resource = getClass().getResource("FXMLDocument.fxml");
    FXMLLoader loader = new FXMLLoader(resource);
    Parent root = (Parent) loader.load();
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}