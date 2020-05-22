public static int read(Reader input, char[] buffer,
                       int offset, int length)
    throws IOException
{
    if (length < 0) {
        throw new IllegalArgumentException("Length must not be negative: " + length);
    }
    int remaining = length;
    while (remaining > 0) {
        int location = length - remaining;
        int count = input.read(buffer, offset + location, remaining);
        if (EOF == count) { // EOF
            break;
        }
        remaining -= count;
    }
    return length - remaining;
}