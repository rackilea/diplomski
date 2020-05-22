import java.io.PrintStream;

public class Test {

    public static void display() {
        System.out.println("Displaying!");
    }

    public static void main(String... args) throws Exception {
        final List<String> outputLog = new ArrayList<String>();
        System.setOut(new PrintStream(System.out) {
            public void println(String x) {
                super.println(x);
                outputLog.add(x);
            }

            // to "log" printf calls:
            public PrintStream printf(String format, Object... args) { 
                outputLog.add(String.format(format, args));
                return this;
            }
        });

        display();
    }
}