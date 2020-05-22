public class NoNewLineOutputStreamWriter extends OutputStreamWriter {

    public NoNewLineOutputStreamWriter(OutputStream out,String charset) throws UnsupportedEncodingException {
        super(out,charset);
    }

    public void write(String str) throws IOException {
        super.write(str.replaceAll("\n", ""));
    };

    public void write(int c) {
        if (c == '\n')
            return;
        else
            super.write(c);
    }

}