class OSCommandLogger extends Thread {
    private static final Logger logger = Logger.getLogger(OSCommandLogger.class);
    private volatile boolean done = false;
    private final String name;
    // Each process is associated with an error and output stream
    private final BufferedReader outputReader;
    private final BufferedReader errorReader;
    private final Logger log;

    /**
     * Reads the output & error streams of the processes and writes them to
     * specified log
     * 
     * @param p
     * @param name
     * @param log
     */
    OSCommandLogger(Process p, String name, Logger log) {
        // Create readers
        outputReader = new BufferedReader(new InputStreamReader(p.getInputStream()));
        errorReader = new BufferedReader(new InputStreamReader(p.getErrorStream()));
        this.log = log;
        if (name != null)
            this.name = name;
        else
            this.name = "OSCommandStreamsLogger";
    }

    private void logLine(BufferedReader reader, boolean isError) {
        try {
            String line = null;
            while ((line = reader.readLine()) != null) {
                if (log != null && log.isDebugEnabled()) {
                    if (!isError)
                        log.debug("[OuputStream] " + line);
                    else
                        log.warn("[ErrorStream] " + line);
                } else
                    logger.debug(line);
            }
        } catch (Exception ex) {
            if (log != null)
                log.error(name + ":" + "Error while reading command process stream", ex);
        }
    }

    public void run() {
        while (!done) {
            logLine(outputReader, false);
            logLine(errorReader, true);

            try {
                // Sleep for a while before reading the next lines
                Thread.sleep(100);
            } catch (InterruptedException e) {
                log.debug("Done with command");
            }
        }

        // Process is done. Close all the streams
        try {
            logLine(outputReader, false);
            outputReader.close();

            logLine(errorReader, true);
            errorReader.close();
            if (log != null && log.isDebugEnabled())
                log.debug(name + ": Closed output/ error Streams.");

        } catch (IOException ie) {
            if (log != null)
                log.error(name + ":" + "Error while reading command process stream", ie);
        }
    }

    public void stopLoggers() {
        if (log != null && log.isDebugEnabled())
            log.debug(name + ":Stop loggers");
        this.done = true;
    }
}