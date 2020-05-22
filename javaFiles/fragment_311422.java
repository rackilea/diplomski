import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class ConcatenatedXmlReader extends BufferedReader {

    private String nextLine = "";

    public ConcatenatedXmlReader(Reader reader, int size) {
        super(reader, size);
    }

    public ConcatenatedXmlReader(Reader reader) {
        super(reader);
    }

    private boolean seenXmlStart = false;

    // which method you need to override probably depends on which sax parser you use
    @Override
    public int read(char[] buffer, int offset, int length) throws IOException {
        readNextLine();
        if (nextLine == null) {
            return -1;
        }
        if (nextLine.startsWith("<?xml")) {
            if (seenXmlStart) {
                return -1;
            }
            seenXmlStart = true;
        }
        int addToBuffer = Math.min(nextLine.length(), length);
        for (int i = 0; i < addToBuffer; i++) {
            buffer[i] = nextLine.charAt(i);
        }
        nextLine = (addToBuffer < nextLine.length()) ? nextLine.substring(addToBuffer) : "";
        return addToBuffer;
    }

    public boolean hasXmlDocuments() throws IOException {
        readNextLine();
        seenXmlStart = false;
        return nextLine != null &&  nextLine.length() > 0;
    }

    private void readNextLine() throws IOException {
        if (nextLine != null && nextLine.length() == 0) {
            nextLine = readLine();
        }
    }

    @Override
    public void close() throws IOException {
        // override so it doesn't close the file when there are still more xml documents.
        if (nextLine != null) {
            return;
        }
        super.close();
    }

}