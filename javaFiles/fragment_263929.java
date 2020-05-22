import java.io.*;
import java.util.Scanner;

public class MyClass {
    public static void main(String[] args) throws IOException {

        try (Scanner s = new Scanner(new BufferedReader(new FileReader("file.txt"))){

            while (s.hasNext()) {
                System.out.println(s.next());
            }
        }
    }
}