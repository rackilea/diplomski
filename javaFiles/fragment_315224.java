static int executeInTerminal(String command) throws IOException, InterruptedException {
    final String[] wrappedCommand;
    if (isWindows) {
        wrappedCommand = new String[]{ "cmd", "/c", "start", "/wait", "cmd.exe", "/K", command };
    }
    else if (isLinux) {
        wrappedCommand = new String[]{ "xterm", "-e", "bash", "-c", command};
    }
    else if (isMac) {
        wrappedCommand = new String[]{"osascript",
                "-e", "tell application \"Terminal\" to activate",
                "-e", "tell application \"Terminal\" to do script \"" + command + ";exit\""};
    }
    else {
        throw new RuntimeException("Unsupported OS ☹");
    }
    Process process = new ProcessBuilder(wrappedCommand)
            .redirectErrorStream(true)
            .start();
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line); // Your superior logging approach here
        }
    }
    return process.waitFor();
}