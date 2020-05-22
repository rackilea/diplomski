Pattern p = Pattern.compile("^(.*):([\\d\\.]+)/(\\d+)$");
Matcher m = p.matcher( someString );
if (m.find()) {
  m.group(1); // returns the text before the colon
  m.group(2); // returns the double between the colon and the slash
  m.group(3); // returns the integer after the slash
}