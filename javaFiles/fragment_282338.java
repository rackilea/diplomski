final byte[] devnull = new byte[1024];

final ProcessBuilder builder = new ProcessBuilder("C:\\test.exe", "param1", "param2")
    .redirectErrorStream(true);
final Process p = builder.start();

final InputStream stdout = process.getInputStream();

// Purge stdout
while (stdout.read[devnull] != -1);

// Grab the process' exit code here