import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Queue;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class Minimal extends Application{

    private Queue<Path> musicList = new LinkedList<>();

    private MediaPlayer mediaPlayer ;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Everyone should have this album. Edit the path if your musical taste is poor.
        Files.find(Paths.get(System.getProperty("user.home"),"Music/iTunes/iTunes Media/Music/Thievery Corporation/Saudade/"), 100,
                (p, a) -> p.toString().toLowerCase().endsWith(".m4a"))
                .forEach(musicList::add);

        playMusic();

        ScrollPane scrollpane = new ScrollPane();
        Image image = new Image("https://upload.wikimedia.org/wikipedia/commons/7/70/Kusatma_Zonaro.jpg");
        ImageView imageView = new ImageView(image);
        scrollpane.setContent(imageView);
        scrollpane.setPannable(true);
        Scene scene = new Scene(new StackPane(scrollpane));
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
        primaryStage.show();

    }

    @Override
    public void stop() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.dispose();
        }
    }

    private void playMusic() {
        if(musicList.peek() == null)
        {
            return;
        }
        mediaPlayer = new MediaPlayer(new Media(musicList.poll().toUri().toString()));
        mediaPlayer.setOnReady(() -> {
            mediaPlayer.play();
            mediaPlayer.setOnEndOfMedia(() -> {
                mediaPlayer.dispose();
                playMusic();
            });
        });

    }
}