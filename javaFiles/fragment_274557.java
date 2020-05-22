public int func(String s, char a, char b) {
  for (int i = 0; i < s.length(); i++) {
    char c = s.charAt(i);
    if (c == a || c == b) {
      return i;
    }
  }
  return -1;
}