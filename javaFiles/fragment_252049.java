public class RsyncCommandLine {

    /** Logger */
    private static final Logger logger = LogManager.getLogger(RsyncCommandLine.class);


    public String startRsync(String source, String destination) throws IOException {
        List<String> commands = createCommandLine(source, destination);
        List<String> lines = new ArrayList<>();
        Integer exitCode = null;
        try {
            ProcessBuilder processBuilder = new ProcessBuilder(commands).redirectErrorStream(true);

            final Process process = processBuilder.start();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
            // Allow process to run up to 60 seconds
            process.waitFor(60, TimeUnit.SECONDS);
            // Get exit code from process
            exitCode = process.exitValue();
            //Convert exit code to meaningful statement
            String exitMessage = exitCodeToErrorMessage(exitCode);               
            lines.add(exitMessage);
        } catch (Exception ex) {
            logger.error(ex);
        }

        return convertLinesToString(lines);
    }


    private String exitCodeToErrorMessage(Integer exitCode) {
        String errorMessage = null;
        switch (exitCode) {
        case 0:
            errorMessage = "Success.";
            break;
        case 1:
            errorMessage = "Syntax or usage error.";
            break;
        case 2:
            errorMessage = "Protocol incompatibility.";
            break;
        case 3:
            errorMessage = "Errors selecting input/output files, dirs.";
            break;
        case 4:
            errorMessage = "Requested action not supported: an attempt was made to manipulate 64-bit files on a platform that cannot support them; or an option was specified that is supported by the client and not by the server.";
            break;
        case 5:
            errorMessage = "Error starting client-server protocol.";
            break;
        case 6:
            errorMessage = "Daemon unable to append to log-file.";
            break;
        case 10:
            errorMessage = "Error in socket I/O.";
            break;
        case 11:
            errorMessage = "Error in file I/O.";
            break;
        case 12:
            errorMessage = "Error in rsync protocol data stream.";
            break;
        case 13:
            errorMessage = "Errors with program diagnostics.";
            break;
        case 14:
            errorMessage = "Error in IPC code.";
            break;
        case 20:
            errorMessage = "Received SIGUSR1 or SIGINT.";
            break;
        case 21:
            errorMessage = "Some error returned by waitpid().";
            break;
        case 22:
            errorMessage = "Error allocating core memory buffers.";
            break;
        case 23:
            errorMessage = "Partial transfer due to error.";
            break;
        case 24:
            errorMessage = "Partial transfer due to vanished source files.";
            break;
        case 25:
            errorMessage = "The --max-delete limit stopped deletions.";
            break;
        case 30:
            errorMessage = "Timeout in data send/receive.";
            break;
        case 35:
            errorMessage = "Timeout waiting for daemon connection.";
            break;
        default:
            errorMessage = "Unrecognised error code.";
        }
        return errorMessage;
    }

    protected String convertLinesToString(List<String> lines) {
        String result = null;

        if (lines != null && !lines.isEmpty()) {
            StringBuilder builder = new StringBuilder();
            for (String line : lines) {
                builder.append(line).append(" ");
            }
            result = builder.toString().trim();
        }
        return result;
    }

    protected List<String> createCommandLine(String source, String destination) {
        // rsync -rtvuch <source> <destination>
        List<String> commands = new ArrayList<>();

        commands.add("rsync");
        commands.add("-rtvuch");

        String escapedSource = source.trim();
        String escapedDestination = destination.trim();

        commands.add(escapedSource);
        commands.add(escapedDestination);
        logger.debug("escapedSource " + escapedSource);
        logger.debug("escapedDestination " + escapedDestination);

        return commands;
    }

}