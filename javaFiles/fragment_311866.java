import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class CaptureOutput implements AutoCloseable {

    private ByteArrayOutputStream stream;
    private PrintStream out;

    public CaptureOutput(ByteArrayOutputStream stream) {
        this.stream = stream;
        this.out = System.out;

        System.setOut(new PrintStream(this.stream));
    }

    public CaptureOutput() {
        this(new ByteArrayOutputStream());
    }

    @Override
    public void close() throws Exception {
        System.setOut(this.out);
    }

    public String getContent() {
        return this.stream.toString();
    }

}