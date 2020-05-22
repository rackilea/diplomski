public void run() {
    try {
        write(this.client.getInputStream(), new File(
            CentralizedLogging.logsDir + File.separator
            + client.getInetAddress().getHostName() + "_"
            + getFormattedDate() + ".log"));
    } catch (Exception e) {
        try {
            e.printStackTrace();
            write(new ByteArrayInputStream(e.getMessage().getBytes()),
                new File(CentralizedLogging.logsDir + File.separator
                + "centralLoggingError.log"));
        } catch (IOException io) {
        }
    } finally {
        // always close in the finally
        this.client.close();
    }
}