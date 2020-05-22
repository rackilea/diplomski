import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class ErrorNotifierExample {
private static final class ErrorDelegatingPrintStream extends PrintStream {
    public ErrorDelegatingPrintStream(PrintStream defaultErr)
            throws FileNotFoundException, UnsupportedEncodingException {
        super(defaultErr);
    }

    @Override
    public void print(boolean b) {
        super.print(b);
        notifyListener(b);
    }

    @Override
    public void print(char c) {
        super.print(c);
        notifyListener(c);
    }

    @Override
    public void print(int i) {
        super.print(i);
        notifyListener(i);
    }

    @Override
    public void print(long l) {
        super.print(l);
        notifyListener(l);
    }

    @Override
    public void print(float f) {
        super.print(f);
        notifyListener(f);
    }

    @Override
    public void print(double d) {
        super.print(d);
        notifyListener(d);
    }

    @Override
    public void print(char[] s) {
        super.print(s);
        notifyListener(s);
    }

    @Override
    public void print(String s) {
        super.print(s);
        notifyListener(s);

    }

    @Override
    public void print(Object obj) {
        super.print(obj);
        notifyListener(obj);

    }

    @Override
    public PrintStream append(CharSequence csq, int start, int end) {
        notifyListener(csq); // TODO will need some special handling
        return super.append(csq, start, end);
    }

    private void notifyListener(Object string) {
        // TODO implement your handling here. System.out printing is just an
        // example.
        System.out.println(String.valueOf(string));
    }
}

public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
    ErrorDelegatingPrintStream errReplacement = new ErrorDelegatingPrintStream(System.err);
    System.setErr(errReplacement);

    System.err.println("TEST01");
    throw new RuntimeException("just a test output for ERROR handling");
}
}