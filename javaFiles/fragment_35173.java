public class EscapeRemovingInputStream extends PushbackInputStream {

    public static void main(String[] args) {
        String s = "\u001B[kHello \u001B[H12JWorld!";
        byte[] buf = s.getBytes(StandardCharsets.ISO_8859_1);
        ByteArrayInputStream bais = new ByteArrayInputStream(buf);
        EscapeRemovingInputStream bin = new EscapeRemovingInputStream(bais);
        try (InputStreamReader in = new InputStreamReader(bin,
                StandardCharsets.ISO_8859_1)) {
            int c;
            while ((c = in.read()) != -1) {
                System.out.print((char) c);
            }
            System.out.println();
        } catch (IOException ex) {
            Logger.getLogger(EscapeRemovingInputStream.class.getName()).log(
                Level.SEVERE, null, ex);
        }
    }

    private static final Pattern ESCAPE_PATTERN = Pattern.compile(
        "\u001B\\[(k|m|H\\d+J|\\d+:\\d+H|\\?\\d+\\w|\\d*i)");
    private static final int MAX_ESCAPE_LENGTH = 20;

    private final byte[] escapeSequence = new byte[MAX_ESCAPE_LENGTH];
    private int escapeLength = 0;
    private boolean eof = false;

    public EscapeRemovingInputStream(InputStream in) {
        this(in, MAX_ESCAPE_LENGTH);
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        for (int i = 0; i < len; ++i) {
            int c = read();
            if (c == -1) {
                return i == 0 ? -1 : i;
            }
            b[off + i] = (byte) c;
        }
        return len;
    }

    @Override
    public int read() throws IOException {
        int c = eof ? -1 : super.read();
        if (c == -1) { // Throw away a trailing half escape sequence.
            eof = true;
            return c;
        }
        if (escapeLength == 0 && c != 0x1B) {
            return c;
        } else {
            escapeSequence[escapeLength] = (byte) c;
            ++escapeLength;
            String esc = new String(escapeSequence, 0, escapeLength,
                    StandardCharsets.ISO_8859_1);
            if (ESCAPE_PATTERN.matcher(esc).matches()) {
                escapeLength = 0;
            } else if (escapeLength == MAX_ESCAPE_LENGTH) {
                escapeLength = 0;
                unread(escapeSequence);
                return super.read(); // No longer registering the escape
            }
            return read();
        }
    }

}