import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.media.*;
import javafx.stage.Stage;

public class VideoPlayerExample extends Application {
    private static final String MEDIA_LOC =
            "http://download.oracle.com/otndocs/products/javafx/oow2010-2.flv";

    @Override
    public void start(final Stage stage) throws Exception {
        final MediaPlayer oracleVid = new MediaPlayer(
                new Media(MEDIA_LOC)
        );

        Label progress = new Label();
        oracleVid.currentTimeProperty().addListener(observable -> {
            progress.setText(
                    oracleVid.getCurrentTime()
                            + " / "
                            + oracleVid.getTotalDuration()
            );
        });

        VBox layout = new VBox(10, progress, new MediaView(oracleVid));
        stage.setScene(new Scene(layout, 540, 208));
        stage.show();

        oracleVid.play();
    }

    public static void main(String[] args) throws Exception {
        launch(args);
    }
}