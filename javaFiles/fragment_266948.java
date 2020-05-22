public class TestClass {

public static void main(final String[] args) {
    @SuppressWarnings("unused")
    final TestClass ts = new TestClass();
}

private BufferedWriter w;
private BufferedReader r;

public TestClass() {
    // Start the process using process builder
    final String programLocation = "\"C:\\Program Files (x86)\\Maxima-sbcl-5.37.2\\bin\\maxima.bat\"";
    final ProcessBuilder pb = new ProcessBuilder();
    pb.command(programLocation);
    Process process;
    try {
        process = pb.start();
    } catch (final IOException e) {
        e.printStackTrace();
        process = null;
        // killProgram();
    }

    // Build your own wrappers for communicating with the program.
    w = new BufferedWriter(
            new OutputStreamWriter(process.getOutputStream()));
    r = new BufferedReader(new InputStreamReader(process.getInputStream()));

    // Print the five starting messages.
    printFromBuffer();
    printFromBuffer();
    printFromBuffer();
    printFromBuffer();
    printFromBuffer();

    // Run the following three commands in Maxima
    runCommand("5+5;");
    runCommand("2*65;");
    runCommand("quit();");
}

/**
 * Runs the given string and prints out the returned answer.
 */
private void runCommand(final String s) {
    try {
        w.write(s);
        w.flush();
        printFromBuffer();
        printFromBuffer();
    } catch (final IOException e) {
        e.printStackTrace();
    }
}

private void printFromBuffer() {
    try {
        final String s = r.readLine();

        System.out.println(s + " -blah");

    } catch (final IOException e) {
        System.err.println(e.getMessage());
        e.printStackTrace();
    }
}
}