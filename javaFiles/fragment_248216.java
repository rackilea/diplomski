public class TextInputForwardingOutputStream extends OutputStream {

    private final TextInputControl control;
    private final Charset charset;

    public TextInputForwardingOutputStream(TextInputControl control) {
        this(control, Charset.defaultCharset());
    }

    public TextInputForwardingOutputStream(TextInputControl control, Charset charset) {
        this.control = control;
        this.charset = charset;
    }

    @Override
    public void write(int b) throws IOException {
        write(new byte[]{(byte) b});
    }

    @Override
    public void write(byte[] b) throws IOException {
        write(b, 0, b.length);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        final String str = new String(b, off, len, this.charset);
        Platform.runLater(() -> this.control.appendText(str));
    }
}