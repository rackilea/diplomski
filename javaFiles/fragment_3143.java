import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.CharBuffer;

public class Main {
    public static void main(String... args) {
        try (FileReader fr = new FileReader("a.txt")) {
            try (BufferedReader reader = new BufferedReader(fr)) {
                 CharBuffer charBuffer = CharBuffer.allocate(8192);
                 reader.read(charBuffer);
            } catch (IOException e) {
                 e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
           e.printStackTrace();
        } catch (IOException e) {
           e.printStackTrace();
        }
   }
}