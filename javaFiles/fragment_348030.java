import java.io.PrintStream;

public class SpyPrintStream extends PrintStream {

    public static void main(String[] args) {
        System.setErr(new SpyPrintStream(System.err));
        System.setOut(new SpyPrintStream(System.out));
        new Exception().printStackTrace();
    }

    public SpyPrintStream(PrintStream src) {
        super(src);
    }

    @Override
    public void println(Object x) {
        if (x instanceof Throwable) {
           super.println("Our spies detected "+ x.getClass().getName());
        }
        super.println(x);
    }
}