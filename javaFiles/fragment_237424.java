class ProcessOutputStreamPrinter extends Thread {

    BufferedReader reader;

    public ProcessOutputStreamPrinter(Process p) {
        reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
    }

    public void run() {
        try {
            String line;
            while (null != (line = reader.readLine()))
                System.out.println("Process output: " + line);
        } catch (IOException e) {
            // handle somehow
        }
    }
}