public static int indexOfAny(String s, String chars) {
  int i = -1;
  for (char c : chars.toCharArray()) {
    int pos = s.indexOf(c);
    if (pos >= 0 && (pos < i || i < 0)) {
      i = pos;
    }     
  }
  return i;
}