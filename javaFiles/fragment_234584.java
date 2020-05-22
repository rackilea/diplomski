String processLine = null;

ProcessBuilder builder = new ProcessBuilder("top", "-b", "-n", "1");
Process proc = builder.start();

try (BufferedReader stdin = new BufferedReader(
    new InputStreamReader(proc.getInputStream()))) {

    String line;
    while ((line = stdin.readLine()) != null) {
        if (line.contains(processName)) {   // No need for grep
            processLine = line;
            break;
        }
    }
}