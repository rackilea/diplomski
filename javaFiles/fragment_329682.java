ProcessBuilder pb = new ProcessBuilder("ps", "-A");
Process p = pb.start();

BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
// Skip first (header) line: "  PID TTY          TIME CMD"
in.readLine();

// Extract process IDs from lines of output
// e.g. "  146 ?        00:03:45 pdflush"
List<String> runningProcessIds = new ArrayList<String>();
for (String line = in.readLine(); line != null; line = in.readLine()) {
    runningProcessIds.add(line.trim().split("\\s+")[0]);
}