Pattern p = Pattern.compile("(.*?)=(.*)");
Matcher m = p.matcher(s);
if (m.matches()) {
  String name = m.group(1);
  String value = m.group(2);      
}