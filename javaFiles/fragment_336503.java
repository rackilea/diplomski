public String removeLastChar(String s) {
  if (s == null || s.length() == 0) {
    return s;
  }
  return s.substring(s.lastIndexOf('/') + 1, s.length() - 10);
}