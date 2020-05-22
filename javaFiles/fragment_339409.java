import java.io.File;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class TestApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        BorderPane pane = new BorderPane();

        FileChooser fc = new FileChooser();
        File mediaFile = fc.showOpenDialog(null);

        MediaView moviePlayer;

        if (mediaFile != null) {
            MediaPlayer player = new MediaPlayer(new Media(mediaFile.toURI().toString()));

            moviePlayer = new MediaView(player);

            moviePlayer.setPreserveRatio(false);
            moviePlayer.fitWidthProperty().bind(pane.widthProperty());
            moviePlayer.fitHeightProperty().bind(pane.heightProperty());

            pane.getChildren().add(moviePlayer);
            player.play();

        }

        Scene scene = new Scene(pane, 300, 300);
        stage.setScene(scene);
        stage.show();
    }
}