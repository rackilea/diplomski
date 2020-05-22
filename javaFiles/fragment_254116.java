public static boolean frontAgain(String str) {
  if (str != null && str.length() > 1) {
    char[] chars = str.toCharArray();
    int len = chars.length;
    return chars[0] == chars[len - 2] && chars[1] == chars[len - 1];
  }
  return false;
}