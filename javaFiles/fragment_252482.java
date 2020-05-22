import java.io.*;
import java.util.Scanner;

public class PersonReader {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner reader = new Scanner(System.in);
        System.out.println("What file would you like to read?: ");
        String textFile = reader.nextLine();

        File f = new File(textFile + ".txt");
        if (f.isFile()) {
            Scanner sc = new Scanner(f);
            StringBuilder sb = new StringBuilder();
            while (sc.hasNextLine()) {
                sb.append(sc.nextLine() + System.lineSeparator());
            }
            System.out.println(sb);
            sc.close();
        }
        else {
            System.out.println("could not find file: " + textFile + ".txt");
        }
        reader.close();
    }
}