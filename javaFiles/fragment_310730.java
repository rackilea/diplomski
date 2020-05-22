public class TiedOutputStream extends PrintStream {

    private final PrintStream sout;
    private final PrintStream serr;

    public TiedOutputStream(File logFile) throws FileNotFoundException {
        super(logFile);
        sout = System.out;//save standard output
        serr = System.err;
    }

    @Override
    public void print(Object obj) {
        super.print(obj);
        sout.print(obj);
    }

    @Override
    public void println(String obj) {
        super.println(obj);
        sout.println(obj);
    }

    @Override
    public PrintStream printf(String format, Object... args) {
        super.printf(format, args);
        sout.printf(format, args);
        return this;
    }

    @Override
    public void println(Object args) {
        super.println(args);
        sout.println(args);
    }

}