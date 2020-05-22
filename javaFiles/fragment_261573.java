import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class StackOverflow {
    public static void main(String[] args) {
        File f = new File("test");
        System.out.println("Length before: " + f.length());
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(f));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Length after: " + f.length());
    }
}