public class RandomString {

    private static final char[] SYMBOLS = "0123456789abcdefghijklmnopqrstuvwxyz".toCharArray();

    private final Random random = new Random();
    private final char[] buf;

    public RandomString(int length) {
        assert length > 0;
        buf = new char[length];
    }

    String nextString() {
        for (int i = 0; i < buf.length; i++) {
            buf[i] = SYMBOLS[random.nextInt(SYMBOLS.length)];
        }
        return new String(buf);
    }
}