public String executeCommand(String[] cmd) {
    StringBuffer theRun = null;
    try {
        Process process = Runtime.getRuntime().exec(cmd);

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(process.getInputStream()));
        int read;
        char[] buffer = new char[4096];
        StringBuffer output = new StringBuffer();
        while ((read = reader.read(buffer)) > 0) {
            theRun = output.append(buffer, 0, read);
        }
        reader.close();
        process.waitFor();

    } catch (IOException e) {
        throw new RuntimeException(e);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
        return theRun.toString().trim();
}