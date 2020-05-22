package mediaviewlayout;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class MediaViewTest extends Application {

    private static final String MEDIA_URL = "http://download.oracle.com/otndocs/products/javafx/oow2010-2.flv";

    @Override
    public void start(Stage primaryStage) throws Exception {
        MediaView mediaView = new MediaView();
        mediaView.setPreserveRatio(true);

        MediaPlayer mediaPlayer = new MediaPlayer(new Media(MEDIA_URL));
        mediaPlayer.setAutoPlay(true);
        mediaView.setMediaPlayer(mediaPlayer);

        VBox controls = new VBox(5);
        controls.setAlignment(Pos.CENTER);
        Slider slider = new Slider();

        controls.getChildren().add(slider);

        Button play = new Button("Play");


        HBox buttons = new HBox(5, play, new Button("Restart"), new Button("Volume"), new Slider());
        buttons.setAlignment(Pos.TOP_CENTER);
        controls.getChildren().add(buttons);

        MediaViewLayout layout = new MediaViewLayout(mediaView, controls);

        Scene scene = new Scene(layout, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}