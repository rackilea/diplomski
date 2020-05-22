import java.io.OutputStream;
import java.io.PrintStream;

public class CheckPrintStream {
    public static void main(String[] args) {
        PrintStream originalSystemOut = System.out;
        System.setOut(new PrintStream(System.out) {
            @Override
            public void write(byte buf[], int off, int len) {
                originalSystemOut.write(buf, off, len);
                if (len > 2) {
                    new RuntimeException("Testing PrintStream nesting").printStackTrace(originalSystemOut);
                }
            }
        });

        for (int i = 0; i < 20; i++) {
            wrapSystemOut();
        }
        System.out.println("Hello World!");

        for (int i = 20; i < 10_000; i++) {
            wrapSystemOut();
        }
        System.out.println("crash!");
    }

    private static void wrapSystemOut() {
        OutputStream tmp = System.out;
        System.setOut(new PrintStream(System.out));
    }
}