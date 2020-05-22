final File logFile = new File("/path/to/logfile");
final ProcessBuilder pb = new ProcessBuilder("powershell", "/path/to/the/ps1");
pb.redirectOutput(Redirect.to(logFile));
pb.redirectErrorStream(true);

final Process p = pb.start();
final int retcode = p.waitFor();

// deal with retcode
// read result from the log file