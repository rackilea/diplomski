public static void executeCommand(final String command) throws IOException, InterruptedException {
    System.out.println("Executing command " + command);
    // Make me a Runtime.
    final Runtime r = Runtime.getRuntime();
    // Start the command process.
    final Process p = r.exec(command);
    // Pipe it's output to System.out.
    try (final BufferedReader b = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
        String line;

        while ((line = b.readLine()) != null) {
            System.out.println(line);
        }
    }
    // Do this AFTER you've piped all the output from the process to System.out
    System.out.println("waiting for the process");
    p.waitFor();
    System.out.println("waiting done");
}