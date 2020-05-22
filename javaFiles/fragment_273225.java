import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Player implements Runnable {

private File song;
private static int BUFFER_SIZE = 4096;

Player(File song) {
    this.song = song;
}

@Override
public void run() {
    try {
        AudioInputStream audioStream = AudioSystem
                .getAudioInputStream(song);
        AudioFormat audioFormat = audioStream.getFormat();
        DataLine.Info info = new DataLine.Info(SourceDataLine.class,
                audioFormat);
        SourceDataLine sourceLine = (SourceDataLine) AudioSystem
                .getLine(info);
        sourceLine.open(audioFormat);
        sourceLine.start();
        int nBytesRead = 0;
        byte[] abData = new byte[BUFFER_SIZE];
        while (nBytesRead != -1) {
            nBytesRead = audioStream.read(abData, 0, abData.length);
        }
        if (nBytesRead >= 0) {
            @SuppressWarnings("unused")
            int nBytesWritten = sourceLine.write(abData, 0, nBytesRead);
        }
        sourceLine.drain();
        sourceLine.close();
    } catch (UnsupportedAudioFileException | IOException e1) {
        e1.printStackTrace();
    } catch (LineUnavailableException e) {
        e.printStackTrace();
    }
}

}