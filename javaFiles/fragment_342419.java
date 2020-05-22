import java.lang.Runnable;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.*;
import java.io.IOException;
import java.io.*;

public class PlaySound implements Runnable {

    BufferedInputStream soundFile;
    Clip clip;
    AudioInputStream stream;

    public PlaySound(String file) throws Exception {
        // we have to create InputStream by ourselves
        InputStream is = new FileInputStream(file);
        soundFile = new BufferedInputStream(is);
    }

    public void run() {
        synchronized(this){

        AudioFormat format;
        DataLine.Info info;

        try {
            // we pass stream instead of file
            // it looks like getAudioInputStream messes around with
            // file
            stream = AudioSystem.getAudioInputStream(soundFile);
            format = stream.getFormat();
            info = new DataLine.Info(Clip.class, format);
            clip = (Clip) AudioSystem.getLine(info);
            clip.open(stream);
            clip.start();
            while(clip.getMicrosecondLength() != clip.getMicrosecondPosition()) {}
            // we can close everything by ourselves
            clip.close();
            stream.close();
            soundFile.close();
        }catch(Exception ex){
            ex.printStackTrace();
        } 

        soundFile = null;
        clip = null;
        stream = null;

        notifyAll();
      }
    }
}