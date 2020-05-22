import java.lang.Thread;
import java.io.IOException;
import java.io.*;
import java.nio.*;
import java.nio.file.*;

public class Main {

    public static void main(String [] arg) throws Exception {

        String filePath = "Sounds/Custom/temp0x.wav";
        PlaySound playSound = new PlaySound(filePath);
        Thread play = new Thread(playSound);
        play.start();
        try {
            play.join();
        } catch(Exception ex) {
          ex.printStacktrace(); 
        }

        System.out.println("play done");
        Path path = FileSystems.getDefault().getPath("Sounds/Custom", "temp0x.wav"); 
        try {
           Files.delete(path);
        } catch (NoSuchFileException x) {
           System.err.format("%s: no such" + " file or directory%n", path);
        } catch (DirectoryNotEmptyException x) {
           System.err.format("%s not empty%n", path);
        } catch (IOException x) {
          // File permission problems are caught here.
          System.err.println(x);
        } catch(Exception ex) {
          ex.printStacktrace();
        }
    }
}