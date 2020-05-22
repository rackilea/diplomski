import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Lesson {
    public static void main(String[] args) {
        File file = new File("mytext.txt");
        try (Scanner input = new Scanner(System.in);
             PrintWriter pw = new PrintWriter(file)) {
            System.out.println("Enter a text here: ");
            String str = input.nextLine();
            while (str.length() > 0) {
                pw.println(str);
                pw.flush();
                str = input.nextLine();
            }
        }
        catch (IOException xIo) {
            xIo.printStackTrace();
        }
        System.out.println("Done");
    }
}