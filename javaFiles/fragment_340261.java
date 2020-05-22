StringBuilder sb = new StringBuilder(str.length());
for (int i = 0; i < str.length(); ++i) {
  char c = str.charAt(i);
  if (Character.isHighSurrogate(c) || Character.isLowSurrogate(c)) {
    // Append the escaped character.
    sb.append("\\u");
    sb.append(String.format("%04x", (int) c));
  } else {
    // Append the character as-is.
    sb.append(c);
  }
}
String partlyEscaped = sb.toString();