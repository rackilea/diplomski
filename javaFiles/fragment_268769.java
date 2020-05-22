public class RedirectedOutput {

    public static void main(String[] args) {
        // Save the old output stream to have the chance to set it back later
        InputStream standardIn  = System.in;
        PrintStream standardOut = System.out;
        PrintStream standardErr = System.err;

        // Set useless streams
        System.setIn(new ByteArrayInputStream(new byte[0]));
        System.setOut(new PrintStream(new ByteArrayOutputStream()));
        System.setErr(new PrintStream(new ByteArrayOutputStream()));

        // Will not be shown
        System.out.println("Hello World");

        // Now set back the old streams to have output again
        System.setIn(standardIn);
        System.setOut(standardOut);
        System.setErr(standardErr);

        // Will be shown again
        System.out.println("Finally we got the Hello");
    }

}