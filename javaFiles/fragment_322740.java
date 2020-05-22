static boolean[] bits(byte b) {
  int n = 8;
  final boolean[] set = new boolean[n];
  while (--n >= 0) {
    set[n] = (b & 0x80) != 0;
    b <<= 1;
  }
  return set;
}