//sound.SoundPlayer
package sound;

import java.net.URL;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class SoundPlayer {

    private MediaPlayer mediaPlayer;

    public SoundPlayer(String filename) {
        URL resource = SoundPlayer.class.getResource(filename);
        Media soundMedia = new Media(resource.toExternalForm());
        mediaPlayer = new MediaPlayer(soundMedia);
    }

    public void play(){
        mediaPlayer.play();
    }
}