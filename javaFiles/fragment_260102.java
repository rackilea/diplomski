@MTOM
@WebService
class Example {
    @WebMethod
    public @XmlMimeType("application/octet-stream") DataHandler service() {
        // Create piped output stream, wrap it in a final array so that the
        // OutputStream doesn't need to be finalized before sending to new Thread.
        PipedOutputStream out = new PipedOutputStream();
        InputStream in = new PipedInputStream(out);
        final Object[] args = { out };

        // Create a new thread which writes to out.
        new Thread(
            new Runnable(){
                public void run() {
                    writeToOut(args);
                    ((OutputStream)args[0]).close();
                }
            }
        ).start();

        // Return the InputStream to the client.
        DataSource ds = new ByteArrayDataSource(in, "application/octet-stream");
        DataHandler dh = new DataHandler(ds);
        return dh;
    }
}