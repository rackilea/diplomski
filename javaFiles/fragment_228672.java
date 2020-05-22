try {
    ProcessBuilder pBuilder = new ProcessBuilder("C:\\speedDIAL\\speedDIAL.exe");

    // don't forget to handle the error stream, and so 
    // either combine error stream with input stream, as shown here
    // or gobble it separately
    pBuilder.redirectErrorStream(true); 
    final Process process = pBuilder.start();
    final InputStream is = process.getInputStream();

    // in case you need to send information back to the process
    // get its output stream. Don't forget to close when through with it
    final OutputStream os = process.getOutputStream();

    // thread to handle or gobble text sent from input stream 
    new Thread(() -> {
        // try with resources
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is));) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                // TODO: handle line
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }).start();

    // thread to get exit value from process without blocking 
    Thread waitForThread = new Thread(() -> {
        try {
            int exitValue = process.waitFor();
            // TODO: handle exit value here
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    });
    waitForThread.start();

    // if you want to join after a certain time:
    long timeOut = 4000;
    waitForThread.join(timeOut);
} catch (IOException | InterruptedException e) {
    e.printStackTrace();
}