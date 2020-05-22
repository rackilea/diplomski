public class CustomPrintStream extends PrintStream {
    private String prefix;

    public CustomPrintStream(String prefix, OutputStream out) {
        super(out);
        this.prefix = prefix;
    }

    @Override
    public void println(String s) {
        if(s.startsWith(prefix))
            super.println(s);
        else {
            System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
            System.out.println(s);
            System.setOut(this);
        }
    }
}