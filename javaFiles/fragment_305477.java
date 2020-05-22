public static void main(final String... args) throws IOException, InterruptedException {
    final Runtime runtime = Runtime.getRuntime();
    final String command = "..."; // cmd.exe

    final Process proc = runtime.exec(command, null, new File("."));

    final BufferedReader input = new BufferedReader(new InputStreamReader(proc.getInputStream()));

    StringBuilder sb = new StringBuilder();
    char[] cbuf = new char[100];
    while (input.read(cbuf) != -1) {
        sb.append(cbuf);
        if (sb.toString().contains("Password:")) {
            break;
        }
        Thread.sleep(1000);
    }
    System.out.println(sb);
}