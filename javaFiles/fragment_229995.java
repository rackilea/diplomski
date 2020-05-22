Pattern p = Pattern.compile("someregex");
Matcher m = p.matcher(s);

StringBuffer sb = new StringBuffer();
while (m.find()) {
    m.appendReplacement(sb, methodFoo(m.group()));
}
m.appendTail(sb);

String result = sb.toString();