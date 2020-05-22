static void removeBlankSpace(StringBuilder sb) {
  int j = 0;
  for(int i = 0; i < sb.length; i++) {
    if (!Character.isWhitespace(sb.charAt(i))) {
       sb.setCharAt(j++, sb.charAt(i));
    }
  }
  sb.delete(j, sb.length);
}