private static final char[] ALPHABET = { '0', '1', '2', '3', ... };

    public static String itoa(int value, final int radix, int width) {
      final char[] buf = new char[width];
      while (width > 0) {
        buf[--width] = ALPHABET[value % radix];
        value /= radix;
      }
      return new String(buf);
    }