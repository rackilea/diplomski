import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Main {

    public static void main(String args[]) {
        Clip clip;
        try {
            clip = AudioSystem.getClip();
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                    Main.class.getResourceAsStream("Morse.aiff"));
            clip.open(inputStream);
            clip.start();
            // optionally, sleep the thread for the duration of the audio clip, 
            // or else you may not hear it
            Thread.sleep(5000); 
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException | InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}