import javafx.application.Application;
import javafx.stage.Stage;

public class JavaFXMediaPlayer extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new MediaSceneGenerator().createScene());
        stage.show();
    }
}