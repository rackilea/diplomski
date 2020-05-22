import java.io.*;

...

System.setOut(new PrintStream(new FilterOutputStream(
        new FileOutputStream(FileDescriptor.out)) {
    public void write(int b) throws IOException {
        if (b == '\u0000') b = ' ';
        super.write(b);
    }
}));