// Make sure not to compile the pattern within the method, to spare us some time.
Pattern p = Pattern.compile("^([0-9]+)([a-z]?)$");

/**
 * Converts a string to a sortable integer, ensuring proper ordering:
 * "1" becomes 256
 * "1a" becomes 353
 * "1b" becomes 354
 * "2" becomes 512
 * "100" becomes 25600
 * "100a" becomes 25697
 */
int getSortOrder(String s) {
  Matcher m = p.matcher(s);
  if(!m.matches()) return 0;
  int major = Integer.parseInt(m.group(1));
  int minor = m.group(2).isEmpty() ? 0 : m.group(2).charAt(0);
  return (major << 8) | minor;
}