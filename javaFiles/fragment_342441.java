String foo = "%u54E6";
Pattern p = Pattern.compile("%u([a-zA-Z0-9]{4})");
Matcher m = p.matcher(foo);
StringBuffer sb = new StringBuffer();
while (m.find()) {
  m.appendReplacement(sb,
      String.valueOf((char) Integer.parseInt(m.group(1), 16)));
}
m.appendTail(sb);
System.out.println(sb.toString());