import java.io.File;
import java.util.Scanner;

public class HelloWorld {
    // The amount of columns per row, where each column is seperated by an arbitrary number
    //  of spaces or tabs
    final static int COLS = 7;

    public static void main(String[] args) {
        System.out.println("Tokens:");
        try (Scanner scanner = new Scanner(new File("input.txt")).useDelimiter("\\s+")) {
            // Counten the current column-id
            int n = 0;
            String tmp = "";
            StringBuilder item = new StringBuilder();
            // Operating of a stream
            while (scanner.hasNext()) {
                tmp = scanner.next();
                n += 1;
                // If we have reached the fifth column, take its content and append the
                // sixth column too, as the name we want consists of space-separated
                // expressions. Feel free to customize of your name-layout varies.
                if (n % COLS == 5) {
                    item.setLength(0);
                    item.append(tmp);
                    item.append(" ");
                    item.append(scanner.next());
                    n += 1;

                    System.out.println(item.toString()); // Doing  some stuff with that
                                                         //expression we got
                }
            }
        }
        catch(java.io.IOException e){
            System.out.println(e.getMessage());
        }
    }
}