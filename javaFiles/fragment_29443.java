class Converter {
  public static String convertLong(final long value) {
    return String.format("%016x", value - Long.MIN_VALUE);
  }

  public static long parseLong(final String value) {
    String first = value.substring(0, 8);
    String second = value.substring(8);
    long temp = (Long.parseLong(first, 16) << 32) | Long.parseLong(second, 16);
    return temp + Long.MIN_VALUE;
  }
}