public final class MSUnescaper
{
    private static final char PERCENT = '%';
    private static final char NONSTANDARD_PCT_ESCAPE = 'u';

    private MSUnescaper()
    {
    }

    public static String unescape(final String input)
    {
        final StringBuilder sb = new StringBuilder(input.length());
        final CharBuffer buf = CharBuffer.wrap(input);

        char c;

        while (buf.hasRemaining()) {
            c = buf.get();
            if (c != PERCENT) {
                sb.append(c);
                continue;
            }
            if (!buf.hasRemaining())
                throw new IllegalArgumentException();
            c = buf.get();
            sb.append(c == NONSTANDARD_PCT_ESCAPE
                ? msEscape(buf) : standardEscape(buf, c));
        }

        return sb.toString();
    }

    private static char standardEscape(final CharBuffer buf, final char c)
    {
        if (!buf.hasRemaining())
            throw new IllegalArgumentException();
        final char[] array = { c, buf.get() };
        return (char) Integer.parseInt(new String(array), 16);
    }

    private static char msEscape(final CharBuffer buf)
    {
        if (buf.remaining() < 4)
            throw new IllegalArgumentException();
        final char[] array = new char[4];
        buf.get(array);
        return (char) Integer.parseInt(new String(array), 16);
    }

    public static void main(final String... args)
    {
        final String input = "AT%26amp%3BT%20Network%20Client%20%u2013%20IBM";
        System.out.println(unescape(input));
    }
}