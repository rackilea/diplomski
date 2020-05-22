import java.net.URI;
import java.net.URISyntaxException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class PlayMP3 extends Application {

    @Override
    public void start(Stage primaryStage) throws URISyntaxException {

        StackPane root = new StackPane();

        URI uri = new URI("http://traffic.libsyn.com/dickwall/JavaPosse373.mp3");
        Media media = new Media(uri.toString());

        //OR Media media = new Media("http://traffic.libsyn.com/dickwall/JavaPosse373.mp3");
        MediaPlayer player = new MediaPlayer(media);
        player.setOnError(new Runnable() {
            @Override
            public void run() {
                System.out.println(media.getError().toString());
            }
        });

        player.setAutoPlay(true);
        root.getChildren().add(new MediaView(player));
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("PlayMP3");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}