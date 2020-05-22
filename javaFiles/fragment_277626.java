import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class VideoPlayerController {    
    private static final String MEDIA_LOC =
            "http://download.oracle.com/otndocs/products/javafx/oow2010-2.flv";

    @FXML
    MediaView mediaView;

    @FXML
    Label progress;

    public void initialize() {
        final MediaPlayer oracleVid = new MediaPlayer(
                new Media(MEDIA_LOC)
        );

        oracleVid.currentTimeProperty().addListener(observable -> {
            progress.setText(
                    oracleVid.getCurrentTime()
                            + " / "
                            + oracleVid.getTotalDuration()
            );
        });

        mediaView.setMediaPlayer(oracleVid);

        oracleVid.play();
    }    
}