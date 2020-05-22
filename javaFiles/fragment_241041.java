String replaceHalf(String input, String search) {
  String reversed = new StringBuilder(search).reverse().toString();
  StringBuilder sb = new StringBuilder(input);
  int pos = -search.length();
  while (true) {
    // Find the next occurrence...
    pos = input.indexOf(search, pos + search.length());
    if (pos == -1) break;

    // ...but ignore it, and find the next occurrence.
    pos = input.indexOf(search, pos + search.length());
    if (pos == -1) break;

    sb.replace(pos, pos + search.length(), reversed);
  }
  return sb.toString();
}