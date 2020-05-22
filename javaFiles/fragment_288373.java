import java.io.IOException;
import java.io.PrintStream;

public class App {

    private PrintStream out;
    private InputReader inputReader;

    public App() {
        this(System.out, new InputReader());
    }

    // constructor injection used by tests
    public App(PrintStream out, InputReader inputReader) {
        this.out = out;
        this.inputReader = inputReader;
    }

    public void execute() throws IOException {
        if (inputReader.determineFile()) {
            out.println(inputReader.removeSpacesDisplaysContents());
        } else {
            out.println("No File!");
        }
    }


    public static void main(String[] args) throws IOException {
        App siema = new App();
        siema.execute();
    }

}