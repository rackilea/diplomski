public static int parseBinary(char[] chars) {
  int res = 0;
  for (int i = 0; i < s.length; ++i) {
    res *= 2;
    if (chars[i] == '1') {
      res += 1;
    }
  }
  return res;
}