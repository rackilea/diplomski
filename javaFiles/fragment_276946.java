logText("Please Wait Until The Testing Is Finished");
logText("Starting Testing...");
String command = "python3 python/Predict.py";

new Thread(new Runnable() {
    public void run() {
        try {
            String line;
            Process process = Runtime.getRuntime().exec(command);

            process.waitFor();
            BufferedReader error = new BufferedReader(new InputStreamReader(process.getErrorStream()));

            error.close();

            BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));

            input.close();

            OutputStream outputStream = process.getOutputStream();
            PrintStream printStream = new PrintStream(outputStream);
            printStream.println();
            printStream.flush();
            printStream.close();
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    // Here, we can safely update the GUI
                    // because we'll be called from the
                    // event dispatch thread
                    logText("Images Created At Output Directory");
                    logText("Testing Completed");
                }
            });
        } catch (IOException ex) {
           Logger.getLogger(MasterFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
        Logger.getLogger(MasterFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}).start();