public static int read(final InputStream input, final byte[] buffer) throws IOException {
    int remaining = buffer.length;
    while (remaining > 0) {
        final int location = buffer.length - remaining;
        final int count = input.read(buffer, location, remaining);
        if (count == -1) { // EOF
            break;
        }
        remaining -= count;
    }
    return buffer.length - remaining;
}