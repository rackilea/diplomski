Process process = new ProcessBuilder(command, and, arguments)
    .redirectErrorStream(true)
    .directory(workingDir)
    .start();

process.waitFor(5, TimeUnit.SECONDS);
process.destroy();
process.waitFor(); // wait for the process to terminate