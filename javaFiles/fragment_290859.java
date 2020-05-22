pb = new ProcessBuilder("cmd.exe", "/c", command, "&&set", "&&exit");
process = pb.start();       
pb.redirectErrorStream(true);

process.waitFor();
exitCode = process.exitValue();

stdout = process.getInputStream ();
stdOutReader = new BufferedReader (new InputStreamReader(stdout));