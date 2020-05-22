String fileText = "34567fgf-kl.)*/676hh";
String pattern = "^\\d+|[^\\w.-]+";

Pattern r = Pattern.compile(pattern);
Matcher m = r.matcher(fileText);

StringBuffer sb = new StringBuffer();
while (m.find()) {
  m.appendReplacement(sb, repeat("_", m.group(0).length()));
}
m.appendTail(sb); // append the rest of the contents
System.out.println(sb);