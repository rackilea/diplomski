import java.io.IOException;
import java.io.ByteArrayInputStream;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;

import java.util.concurrent.CountDownLatch;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SimpleWavPlayer {
    public static void main(String[] args)
    throws IOException,
           InterruptedException,
           LineUnavailableException,
           UnsupportedAudioFileException {

        for (String arg : args) {
            Path file = Paths.get(arg);
            byte[] decoded = Files.readAllBytes(file);

            AudioInputStream audioIn = AudioSystem.getAudioInputStream(
                new ByteArrayInputStream(decoded));
            Clip song = AudioSystem.getClip();
            song.open(audioIn);
            song.start();

            // Wait for clip to finish.
            final CountDownLatch latch = new CountDownLatch(1);
            song.addLineListener(new LineListener() {
                @Override
                public void update(LineEvent event) {
                    if (event.getType().equals(LineEvent.Type.STOP)) {
                        event.getLine().close();
                        latch.countDown();
                    }
                }
            });
            latch.await();
        }
    }
}