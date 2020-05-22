private static int execute(String command) {
    Runtime runtime = null;
    Process process = null;

    int exitValue = -1;
    BufferedInputStream bis = null;

    try {
        runtime = Runtime.getRuntime();

        process = runtime.exec(new String[] { "/bin/bash", "-c", command });
        bis = new BufferedInputStream(process.getInputStream());

        byte[] b = new byte[1892];
        while (bis.read(b) != -1) {
        }

        exitValue = process.waitFor();

        if (bis != null) {
            try {
                bis.close();
            } catch (IOException e) {
            }
        }
        if (process != null) {
            process.destroy();
        }
    } catch (Exception e) {
        //Logging
    }

    return exitValue;
}