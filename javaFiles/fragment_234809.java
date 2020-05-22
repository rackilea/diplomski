StringBuffer sb = new StringBuffer();
Matcher m = Pattern.compile("([a-z])([^. -]*)", Pattern.CASE_INSENSITIVE).matcher(s);
while (m.find()) {
    m.appendReplacement(sb, m.group(1).toUpperCase() + m.group(2).toLowerCase());
}
System.out.println(m.appendTail(sb).toString());