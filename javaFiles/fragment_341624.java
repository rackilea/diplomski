import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Deck extends Application {

   public static void main(String[] args) {
      Application.launch(args);
   }


   @Override
   public void start(Stage stage) {
      Group root = new Group(new Label("Hello JavaFX!"));
      Scene scene = new Scene(root, 1024, 786);
      stage.setScene(scene);
      stage.show();
   }
}