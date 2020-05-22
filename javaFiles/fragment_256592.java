public class LoggingReader extends InputStreamReader {

    private char[] lastRead;

    public LoggingReader(final InputStream inputStream, final Charset charset) {
        super(inputStream, charset);
    }

    @Override
    public int read(final char[] chars, final int i, final int i1) throws IOException {
        final int result = super.read(chars, i, i1);
        lastRead = chars;
        return result;
    }

    public String getLastRead() {
        return new String(lastRead);
    }
}

public class LoggingJsonReader extends JsonReader {
    private final LoggingReader reader;
    public LoggingJsonReader(final LoggingReader in) {
        super(in);
        this.reader = in;
    }

    public String getLastRead() {
        return reader.getLastRead();
    }
}