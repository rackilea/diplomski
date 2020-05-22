import java.io.*;

class SystemOutLogging {

    public static void main(String[] args) throws IOException,
                                                  ClassNotFoundException {
        final PrintStream original = System.out;

        System.setOut(new PrintStream("programlog.txt") {
            public void println(String str) {
                process(str + "\n");
            }

            public void print(String str) {
                process(str);
            }

            private void process(String str) {
                // Fill some JEditorPane
                original.println("Program printed: \"" + str + "\"");
            }
        });

        System.out.print("Hello ");
        System.out.println(" World");
    }
}