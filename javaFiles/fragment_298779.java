import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) throws IOException {
        URL url = new URL("http://www.google.com");

        Scanner s = new Scanner(url.openConnection().getInputStream());
        while (s.hasNextLine())
            System.out.println(s.nextLine());
    }
}