import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ReadOnlyHex {

private static Pattern pattern = Pattern.compile("0x\\d{4}");
public static void main(String[] args) throws FileNotFoundException {
    Scanner in = new Scanner(new File("c:/temp/input.txt"));

    while(in.hasNextLine()) {
        String token = in.findInLine(pattern);

        if (token == null) {
            in.nextLine();
            continue;
        }

        System.out.println(token.getBytes());
    }

    in.close();
}

}