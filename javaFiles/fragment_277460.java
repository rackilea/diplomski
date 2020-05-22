public class ReverseOutputStreamWriter extends Writer {
    private OutputStream out;
    private Charset encoding;
    public ReverseOutputStreamWriter(OutputStream out, Charset encoding) {
        this.out = out;
        this.encoding = encoding;
    }
    public void write(int ch) throws IOException {
        byte[] buffer = this.encoding.encode(String.valueOf(ch)).array();
        // write the bytes in reverse order to this.out
    }
    // other overloaded methods
}