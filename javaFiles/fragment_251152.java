static void printCode(int code) {
  final StringBuilder buffer = new StringBuilder();
  do {
    final int digit = (code - 1) % 26;
    buffer.insert(0, (char)(digit + 'a'));
    code = (code - digit - 1) / 26;
  } while (code > 0);
  System.out.println(buffer);
}