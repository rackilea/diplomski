abstract public class TranslatingReader extends Reader {

    private BufferedReader input;
    private StringReader output;

    public TranslatingReader(Reader in) {
        input = new BufferedReader(in);
        output = new StringReader("");
    }

    abstract public String translate(String line);

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        int read = 0;

        while (len > 0) {
            int nchars = output.read(cbuf, off, len);
            if (nchars == -1) {
                String line = input.readLine();
                if (line == null) {
                    break;
                }

                line = tranlate(line);

                line += "\n"; // Add the newline which was removed by readLine()
                output = new StringReader(line);
            } else {
                read += nchars;
                off += nchars;
                len -= nchars;
            }
        }

        if (read == 0)
            read = -1;

        return read;
    }

    @Override
    public void close() throws IOException {
        input.close();
        output.close();
    }
}