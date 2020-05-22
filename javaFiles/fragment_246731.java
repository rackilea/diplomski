Function<String[], Process> processProvider = (commandArr) -> {
    ProcessBuilder pb = new ProcessBuilder(commandArr);
    pb.redirectErrorStream(true);
    try {
        return pb.start();
    } catch (IOException ex) {
        throw new RuntimeException(ex);
};