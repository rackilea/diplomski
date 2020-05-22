static final char[] ENCODE = new char[100];

static {
    int x = 0;
    for (char i = ' ' + 1; i < 256 && x < 100; i++)
        if (!Character.isLowerCase(i) && !Character.isWhitespace(i))
            ENCODE[x++] = i;
    assert x == ENCODE.length;
}

public static char[] encode(int n) {
    assert n >= 0 && n < 100000000;
    char[] ret = new char[4];
    for (int i = ret.length - 1; i >= 0; i--) {
        ret[i] = ENCODE[n % 100];
        n /= 100;
    }
    return ret;
}

public static int decode(char[] chars) {
    int n = 0;
    for (char ch : chars) {
        int x = Arrays.binarySearch(ENCODE, ch);
        assert x >= 0;
        n = n * 100 + x;
    }
    return n;
}

public static void main(String... args) {
    char[] chars = encode(12345678);
    System.out.println("Encoded: " + new String(chars));
    int n = decode(chars);
    System.out.println("Dencoded: " + n);
}