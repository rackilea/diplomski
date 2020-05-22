public static final int EOF = -1;

public static int read(final InputStream input, final byte[] buffer, final int offset, final int length)
        throws IOException {
    if (length < 0) {
        throw new IllegalArgumentException("Length must not be negative: " + length);
    }
    int remaining = length;
    while (remaining > 0) {
        final int location = length - remaining;
        final int count = input.read(buffer, offset + location, remaining);
        if (EOF == count) { // EOF
            break;
        }
        remaining -= count;
    }
    return length - remaining;
}