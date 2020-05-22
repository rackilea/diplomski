public static final String          NL = System.getProperty("line.separator", "\n");

public <T extends Appendable> int command(String... cmd) throws Exception {
    return command(null, cmd);
}

public <T extends Appendable> int command(T out, String... cmd) throws Exception {
    try {

        final ProcessBuilder pb = new ProcessBuilder(cmd);

        pb.redirectErrorStream(true);

        final Process proc = pb.start();
        final BufferedReader rd = new BufferedReader(new InputStreamReader(proc.getInputStream()));

        for (;;) {
            final String line = rd.readLine();

            if (line == null) {
                break;
            }

            if (out != null) {
                out.append(line);
                out.append(NL);
            }
        }

        return proc.waitFor();

    } catch (InterruptedException e) {
        throw new IOException(e);
    }
} 

public void startProcessWithTitle(String pathToExe, String title) throws Exception {
    command("cmd.exe", "/C", "start", '"' + pathToExe + '"', '"' + title + '"', ..cmd.params..);
}

public int findProcessByTitle(String title) throws Exception {

    final StringBuilder list = new StringBuilder();

    if (command(list, "tasklist", "/V", "/FO", "csv") != 0) {
        throw new RuntimeException("Cannot get tasklist. " + list.toString());
    }

    final CSVReader csv = new CSVReader(new StringReader(list.toString()), ',', true, "WindowsOS.findProcessByTitle");
    csv.readHeaders(true); // headers

    int pidIndex = csv.getHeaderIndex("PID");
    int titleIndex = csv.getHeaderIndex("Window Title");

    while (csv.nextLine()) {
        final String ttl = csv.getString(titleIndex, true);
        if (ttl.contains(title)) {
            return csv.getInt(pidIndex);                
        }
    }

    Utils.close(csv);

    return -1;
}

public boolean killProcess(int pid) throws Exception {
    return command("taskkill", "/T", "/F", "/PID", Integer.toString(pid)) == 0;
}