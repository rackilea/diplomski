public void runCommandLine(String directory) throws IOException {
    ProcessBuilder processBuilder = new ProcessBuilder(
                    "/bin/bash -c " + command);
    processBuilder.directory(new File(directory));
    Process process = processBuilder.start();
    Thread commandLineThread = new Thread(() -> {
        try {
            printStream(process.getErrorStream(), true);
            printStream(process.getInputStream(), true);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    });
    commandLineThread.setDaemon(true);
    commandLineThread.start();
    System.out.println("Task Dispatched");
}