import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Quiz9 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("/Users/abc/input.txt"));
        PrintWriter out = new PrintWriter("/Users/abc/output.txt");
        String a;
        while (in.hasNextLine()) {
            a = in.nextLine();
            char b = a.charAt(3);
            char c = a.charAt(4);
            out.write(b + "" + c + "\n");
        }
        in.close();
        out.close();
    }
}