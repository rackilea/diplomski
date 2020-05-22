class LogingInputStream extends BufferedStream {
    ByteArrayOutputStream copy4log = new ByteArrayOutputStream();
    InputStream source;

    public LogingInputStream( InputStream source ) { this.source = source; }

    public int read() {
        int value = source.read()
        logCopy.write( value );
        return value;
    }

    public void close() {
        source.close();
        StreamUtils.copy(xml, new LogOutputStreamUtil(copy4log, Level.INFO));
        copy4log.close();
    }

    .....more code here
}