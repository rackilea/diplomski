import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import java.io.*;

public class Main {
    public static void main(String args[]) {
        String filename = "/usr/share/lmms/samples/shapes/technosynth6.wav";
        File fileIn = new File(filename);
        try {
            AudioInputStream in = AudioSystem.getAudioInputStream(fileIn);
            System.out.println("format. " + in.getFormat());
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}