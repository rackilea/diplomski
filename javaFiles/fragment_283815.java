import java.io.FileReader;
import java.util.Scanner;


public class MagellanSchoolQ2Coursework2 {
    public static void main(String[] args) {
        try {
            Scanner detailsIn =new Scanner(new FileReader("c:\\s.txt"));
            detailsIn.close();
        } catch (FileNotFoundException e) {
            System.out.println("file not found: s.txt");
        }
    }
}