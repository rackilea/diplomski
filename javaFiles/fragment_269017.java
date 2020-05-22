import java.io.*;
import java.util.*;

public class Test {
    public static void main(String[] args) throws IOException {
        // Not closing anything just for convenience
        String text = "a\tb\t\r\nc\td\t";
        Scanner scanner = new Scanner(new StringReader(text));

        while (scanner.hasNextLine())
        {
            String line = scanner.nextLine();
            System.out.println(line.replace("\t", "<tab>"));
        }
    }
}