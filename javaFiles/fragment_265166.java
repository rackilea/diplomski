public static String runProcess(String executable, String parameter) {
    try {
        String path = String.format("%s %s", executable, parameter);
        Process pr = Runtime.getRuntime().exec(path);

        StreamGobbler errorGobbler = new StreamGobbler(pr.getErrorStream());
        StreamGobbler outputGobbler = new StreamGobbler(pr.getInputStream());

        // kick them off concurrently
        errorGobbler.start();
        outputGobbler.start();

        pr.waitFor();
        return outputGobbler.getOutput();
    } catch (Exception e) {
        return null;
    }
}