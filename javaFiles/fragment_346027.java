import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class ProgressBarTest extends Application {

    public static void main(String[] args) { launch(args); }

    @Override
    public void start(final Stage stage) throws Exception {
        //All the controls are added here
        VBox box = new VBox();
        box.getStylesheets().add("test.css");
        ProgressBar pb = new ProgressBar(50);

        box.getChildren().add(pb);

        //Setting up your scene
        Scene scene = new Scene(box);
        stage.setScene(scene);

        stage.show();
    }
}