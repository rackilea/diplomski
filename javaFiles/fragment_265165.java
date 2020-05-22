class StreamGobbler extends Thread {
    InputStream is;
    String output;

    StreamGobbler(InputStream is) {
        this.is = is;
    }

    public String getOutput() {
        return output;
    }

    public void run() {
        try {
            StringWriter writer = new StringWriter();
            IOUtils.copy(is, writer);
            output = writer.toString();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}