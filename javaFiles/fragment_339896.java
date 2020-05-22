// Static level, because it doesn't depend on outside state.
public static List<String> getPhrases(
    StringBuilder fileContent, String token) {
  // An output List.
  List<String> al = new ArrayList<String>();
  final int p1 = fileContent.indexOf(token);
  if (p1 >= 0) { // we have a "token"
    int pos1 = fileContent.indexOf("[", p1 + 1);
    if (pos1 >= 0) { // we have an open "["
      int pos2 = fileContent.indexOf("]", pos1 + 1);
      if (pos2 >= 0) { // we have a closing "]"
        String str = fileContent.substring(pos1 + 1,
            pos2);
        StringTokenizer st = new StringTokenizer(
            str, ","); // Now use a Tokenizer.
        while (st.hasMoreTokens()) {
          String s = st.nextToken();
          if (s != null) { // Don't trim a null!
            al.add(s.trim());
          } else { // You may not want this...
            al.add("");
          }
        }
      }
    }
  }
  // Return that output List.
  return al;
}