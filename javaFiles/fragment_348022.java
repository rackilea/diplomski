BufferedReader bufferedReader = new BufferedReader(
        new InputStreamReader(
            new ImpatientInputStream(process.getInputStream())
        ));


public class ImpatientInputStream extends InputStream {

    private final InputStream in;
    private boolean eof;

    public ImpatientInputStream(InputStream in) {
        this.in = in;
    }

    @Override
    public int read() throws IOException {
        if (eof) {
            return -1; 
        }
        if (available() == 0) {
            eof = true;
            return -1;
        }
        return in.read();
    }

}