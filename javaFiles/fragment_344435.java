public class BufferedWriterWithFormat extends BufferedWriter {
    private String format;

    public BufferedWriterWithFormat(Writer w, String format) {
        super(w);
        this.format = format;
    }

    public void write(double d) throws IOException {
        write(String.format(format, d));
    }
}