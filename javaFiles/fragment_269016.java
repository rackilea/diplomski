import java.io.*;

public class Test {
    public static void main(String[] args) throws IOException {
        // Not closing anything just for convenience
        String text = "a\tb\t\r\nc\td\t";
        BufferedReader reader = new BufferedReader(new StringReader(text));

        String line;

        while ((line = reader.readLine()) != null)
        {
            System.out.println(line.replace("\t", "<tab>"));
        }
    }
}