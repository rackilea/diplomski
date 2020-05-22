class SafeWriter {
    private final Writer writer;
    public SafeWriter(Writer writer) {
        this.writer = writer;
    }
    public void write(int n) {
        try {
            writer.write(n);
        } catch (IOException e) {
            handleException(e);
        }
    }
    public void write(String s) {
        try {
            writer.write(s);
        } catch (IOException e) {
            handleException(e);
        }
    }
    ... // Provide wrappers for other methods here
    private void handleException(IOException e) {
        ...
    }
}