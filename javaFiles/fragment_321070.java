import java.io.InputStream;
import java.io.PrintStream;


public class CallableTask implements MyCallable<Object> {

    private InputStream in = System.in;
    private PrintStream out = System.out;

    public void setStdIn(InputStream in) {
        this.in = in;
    }

    public void setStdOut(PrintStream out) {
        this.out = out;
    }

    public Object call() throws Exception {
        out.write(in.read());
        return null;
    }