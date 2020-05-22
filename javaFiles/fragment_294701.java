Process p = Runtime.getRuntime().exec("Command");
OSCommandLogger logger = new OSCommandLogger(p, "Command", log);

// Start the thread using thread pool
threadExec.executeRunnable(logger);
int exitValue = p.waitFor(); // Wait till the process is finished

// Required to stop the logger threads
logger.stopLoggers();
logger.interrupt();