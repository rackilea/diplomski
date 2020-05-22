StringBuilder sb = new StringBuilder(t.length());
for (int i = 0; i < t.length(); ++i) {
  if (t.charAt(i) != '*'                     // Check the current character.
      && (i == 0 || t.charAt(i - 1) != '*')  // Check the prev character.
      && (i + 1 >= t.length() || t.charAt(i + 1) != '*')) {  // Check the next.
    sb.append(t.charAt(i));
  }
}
t = sb.toString();