static Random rand = new Random();

static String getPassword(String alphabet, int len) {
  StringBuilder sb = new StringBuilder(len);
  while (sb.length() < len) {
    char ch = alphabet.charAt(rand.nextInt(alphabet.length()));
    if (sb.length() > 0) {
      if (sb.charAt(sb.length() - 1) != ch) {
        sb.append(ch);
      }
    } else {
      sb.append(ch);
    }
  }
  return sb.toString();
}