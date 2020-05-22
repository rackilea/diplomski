import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SoundClipTest{

   public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
       URL myURL= ClassLoader.getSystemResource("abesti.wav");
       AudioInputStream audio = AudioSystem.getAudioInputStream(myURL);
       Clip clip = AudioSystem.getClip();
       clip.open(audio);
       clip.setMicrosecondPosition(3000000);
       clip.start();
       try {
        Thread.sleep(2000); //in milliseconds
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
       clip.stop();
   }
}