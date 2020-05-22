public static int[] countDigits(final String str) {
  final int[] freq = new int[10];
  for (final char c : str.toCharArray()) {
    if (Character.isDigit(c)) {
      ++freq[c - '0'];
    }
  }
  return freq;
}