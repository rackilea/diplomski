import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;
import java.lang.Runnable;

public class MusicBackground implements Runnable {

public void run() throws Exception {
URL url = MusicBackground.class.getResource("backgroundMusic.wav");
AudioClip clip = Applet.newAudioClip(url);
clip.play();
Thread.sleep(1000);
clip.loop();
}
}