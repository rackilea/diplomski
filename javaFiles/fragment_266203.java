public static List<String> getPidsOfJavaProcesses() throws ProcessException {

    List<String> pids = null;
    boolean isOnWindows = isOnWindows();

    if (isOnWindows) {
        String[] commandParams = getCommandParamsForGettingProcessesOnWindows();
        Process pr = executeConsoleCommand(commandParams);
        pids = getConsoleOutput(pr);
    } else {
        String[] commandParams = getCommandParamsForGettingProcessesOnLinux();
        Process pr = executeConsoleCommand(commandParams);
        List<String> outputLines = getConsoleOutput(pr);
        pids = getJavaPidsFromConsoleOutputOnLinux(outputLines);
    }

    return pids;
}

public static boolean isOnWindows() {
    boolean isOnWindows = false;
    String osName = System.getProperty("os.name");
    if (osName.toLowerCase().contains("windows")) {
        isOnWindows = true;
    }

    return isOnWindows;
}

private static String[] getCommandParamsForGettingProcessesOnLinux() {

    String[] params = new String[3];
    params[0] = "bash";
    params[1] = "-c";
    params[2] = "ps -fe | grep \"java\"";

    return params;
}

private static String[] getCommandParamsForGettingProcessesOnWindows() {

    String[] params = new String[11];
    params[0] = "cmd";
    params[1] = "/c";
    params[2] = "wmic";
    params[3] = "process";
    params[4] = "where";
    params[5] = "name=\"javaw.exe\"";
    params[6] = "get";
    params[7] = "processid";
    params[8] = "|";
    params[9] = "MORE";
    params[10] = "+1";

    return params;
}

public static Process executeConsoleCommand(String[] params) throws ProcessException {

    // Create the process
    final ProcessBuilder processBuilder = new ProcessBuilder(params);

    // Redirect errors to avoid deadlocks when the buffers get full.
    processBuilder.redirectErrorStream(true);

    // Launch the process
    Process process = null;
    try {
        process = processBuilder.start();
    } catch (IOException e) {
        log.error("Exception launching a process", e);
        throw new ProcessException("Exception launching a process", e);
    }

    return process;
}

public static List<String> getConsoleOutput(Process process) throws ProcessException {
    List<String> lines = new ArrayList<String>();
    InputStream input = process.getInputStream();
    BufferedReader reader = new BufferedReader(new InputStreamReader(input));

    try {
        String line = reader.readLine();
        while (line != null) {
            line = line.trim();
            if (!line.isEmpty()) {
                lines.add(line);
            }
            line = reader.readLine();
        }
    } catch (IOException e) {
        log.error("It was not possible to obtain the process output", e);
        throw new ProcessException("It was not possible to obtain the process output", e);
    } finally {
        try {
            if (input != null) {
                input.close();
            }
            if (reader != null) {
                reader.close();
            }
        } catch (IOException e) {
            log.error("It was not possible to close the console stream", e);
            throw new ProcessException("It was not possible to close the console stream", e);
        }
    }

    return lines;
}