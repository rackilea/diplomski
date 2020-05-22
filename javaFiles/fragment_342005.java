import static javafx.application.Application.launch;
import javafx.application.*;
import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class IconApp extends Application {
  @Override public void start(Stage stage) {
    Image image = new Image(
      "http://icons.iconarchive.com/icons/tooschee/misc/128/Present-icon.png"
    );
    stage.getIcons().setAll(image);

    final VBox layout = new VBox(10);
    layout.setStyle("-fx-background-color: cornsilk; -fx-padding: 10;");
    layout.getChildren().setAll(new ImageView(image));

    stage.setScene(new Scene(layout));
    stage.show();
  }

  public static void main(String[] args) { launch(args); }
}

// icon license (creative commons 3 with attribution): 
//   http://creativecommons.org/licenses/by-nc/3.0/
// icon attribution: 
//   http://tooschee.com/portfolio?worksCategory=icons