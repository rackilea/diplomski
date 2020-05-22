import java.io.File;

import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class MediaPlayerSample extends Application {

    private File[]      files;
    private int         nextIdx;
    private MediaPlayer activePlayer;

    public static void main(String[] args) {
        launch(args);
    }

    private void playNext() {
        if (files == null || files.length == 0) {
            return;
        }

        Media media = new Media(files[nextIdx++].toURI().toString());
        if (nextIdx >= files.length) {
            nextIdx = 0;
        }

        if (activePlayer != null) {
            activePlayer.stop();
            // This is the magic code
            activePlayer.dispose();
        }

        activePlayer = new MediaPlayer(media);
        activePlayer.setOnEndOfMedia(new Runnable() {
            @Override
            public void run() {
                playNext();
            }
        });

        activePlayer.play();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        File fDir = new File("/mp3-files/");
        files = fDir.listFiles();
        playNext();
    }

}