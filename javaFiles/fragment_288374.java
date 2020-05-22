import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static java.lang.System.out;

public class InputReader {

    private InputStream in;
    private InputStream file;

    public InputReader() {
        this(System.in);
    }

    // constructor injection used by tests
    public InputReader(InputStream in) {
        this.in = in;
    }

    public boolean determineFile() {
        out.println("Enter filename:");
        try {
            file = getResource("/" + readLine(in));
            return true;
        } catch (IOException e) {
            out.println("Error determining file!");
            return false;
        }
    }

    public String removeSpacesDisplaysContents() throws IOException {
        return deleteWhitespace(readLine(file));
    }

    private String deleteWhitespace(String input) {
        return input.replaceAll("\\s+", "");
    }

    // to be overridden in tests
    InputStream getResource(String name) throws IOException {
        return getClass().getResourceAsStream(name);
    }

    // to be overridden in tests
    String readLine(InputStream is) throws IOException {
        return new BufferedReader(new InputStreamReader(is)).readLine();
    }

}