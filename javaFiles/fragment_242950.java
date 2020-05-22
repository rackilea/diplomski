import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {

public static void main(String args[]) {
    File file = new File("C:\\some_folder\\flowers_petal.txt");
    Scanner in;
    try {
        in = new Scanner(file);
        while (in.hasNext()) {
            String line = in.nextLine();
            System.out.println(line);
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }

}
}