/* Decompose original "accented" string to basic characters. */
String decomposed = Normalizer.normalize(accented, Normalizer.Form.NFKD);
/* Build a new String with only ASCII characters. */
StringBuilder buf = new StringBuilder();
for (int idx = 0; idx < decomposed.length(); ++idx) {
  char ch = decomposed.charAt(idx);
  if (ch < 128)
    buf.append(ch);
}
String filtered = buf.toString();