import java.io.*;

public class TestForArcaneEOF {
    public static void main(String[] args) throws IOException {
        Reader reader;
        if (args.length == 0) {
            reader = new InputStreamReader(System.in);
        } else {
            reader = new FileReader(args[0]);
        }
        reader = new BufferedReader(reader);
        int last = 0;
        int ch;
        while ((ch = reader.read()) != -1) {
            last = ch;
        }
        if (last == 0x1a) {
            System.out.println("Ends with ^Z");
        } else {
            System.out.println("Doesn't end with ^Z");
        }
    }
}