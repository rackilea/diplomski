public String newIndex(String str, int oldIndex) {
  int newIndex = 0;
  boolean inBracket = false;
  for (int i = 0; i < str.length(); i++) {
    if (i == oldIndex) return newIndex;
    char c = str.charAt(i);
    if (c == '<') inBracket = true;
    else if (c == '>') inBracket = false;
    else if (!inBracket) newIndex++;
  }
  return newIndex;
}