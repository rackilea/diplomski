class Test {
    public static void main(String[] args) throws IOException {

        // Start external process. (Replace "cat" with whatever you want.)
        ProcessBuilder pb = new ProcessBuilder("cat");
        Process p = pb.start();

        // Start printing it's output to System.out.
        new ProcessOutputStreamPrinter(p).start();

        // Just for testing:

        // Print something ourselves:
        System.out.println("My program output: hello");

        // Give cat some input (which it will echo as output).
        PrintWriter pw = new PrintWriter(new PrintStream(p.getOutputStream()));
        pw.println("hello");
        pw.flush();

        // Close stdin to terminate "cat".
        pw.close();
    }
}