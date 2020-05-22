sendCommand("homepath/plugins", "mvn", "archetype:generate", "-DarchetypeCatalog=file://homepath/.m2/repository");

private static void sendCommand(String workingDirectory, String... command) throws IOException {
    Process proc = new ProcessBuilder(command).directory(new File(workingDirectory)).start();
    int status = proc.waitFor();
    if (status != 0) {
        // Handle non-zero exit code, which means the command failed
    }
}