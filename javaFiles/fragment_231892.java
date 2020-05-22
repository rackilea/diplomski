public class Test {
    public static void main(String[] args) {

        // Create logged PrintStreams
        LoggedPrintStream lpsOut = LoggedPrintStream.create(System.out);
        LoggedPrintStream lpsErr = LoggedPrintStream.create(System.err);

        // Set them to stdout / stderr
        System.setOut(lpsOut);
        System.setErr(lpsErr);

        // Print some stuff
        System.out.print("hello ");
        System.out.println(5);
        System.out.flush();

        System.err.println("Some error");
        System.err.flush();

        // Restore System.out / System.err
        System.setOut(lpsOut.underlying);
        System.setErr(lpsErr.underlying);

        // Print the logged output
        System.out.println("----- Log for System.out: -----\n" + lpsOut.buf);
        System.out.println("----- Log for System.err: -----\n" + lpsErr.buf);
    }
}