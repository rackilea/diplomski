private static final int SIZE = 200000000;
private static final int COUNT = 309;
private static final char[] CHARS;
private static final char[] BYTES = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
private static final String IN_FILE = "E:\\temp\\in.dat";
private static final String CHAR_FILE = "E:\\temp\\char.dat";
private static final String BLOCK_FILE = "E:\\temp\\block.dat";

static {
  char[] chars = new char[1000];
  int nchars = 0;
  for (char c = 'a'; c <= 'z'; c++) {
    chars[nchars++] = c;
    chars[nchars++] = Character.toUpperCase(c);
  }
  for (char c = '0'; c <= '9'; c++) {
    chars[nchars++] = c;
  }
  chars[nchars++] = ' ';
  CHARS = new char[nchars];
  System.arraycopy(chars, 0, CHARS, 0, nchars);
}