import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class test {

    public static void main(String[] args) {
        File f = new File("Sample.txt");
        if (!f.exists()) {
            System.out.println("File not Found");
        }
        else {
            try {
                FileOutputStream s = new FileOutputStream(f);
            } catch (FileNotFoundException e) {}
        }
    }
}