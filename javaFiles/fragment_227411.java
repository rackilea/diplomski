import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sandbox {

    protected static final Object LOCK = new Object();

    public static void main(String[] args) {
        try {
            URL url = Sandbox.class.getResource("/sound-effects/Loud-alarm-clock-sound.wav");
            AudioInputStream ais = AudioSystem.getAudioInputStream(url);
            AudioFormat af = ais.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, af);

            Clip clip = (Clip) AudioSystem.getLine(info);
            clip.open(ais);

            clip.addLineListener(new LineListener() {
                @Override
                public void update(LineEvent event) {
                    System.out.println(event.getType());
                    if (event.getType() == LineEvent.Type.STOP) {
                        synchronized (LOCK) {
                            LOCK.notify();
                        }
                    }
                }
            });
            clip.start();

            synchronized (LOCK) {
                LOCK.wait();
            }
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException exp) {
            exp.printStackTrace();
        }
    }

}