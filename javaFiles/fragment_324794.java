String longer = str1;
String shorter = str2;
if(str2.length() > str1.length()) {
    longer = str2;
    shorter = str1;
}
Pattern p = Pattern.compile(Pattern.quote(longer) + "|" + Pattern.quote(shorter));
Matcher m = p.matcher(source);
StringBuffer sb = new StringBuffer();
while (m.find()) {
    String replacement = str1;
    if(m.group(0).equals(str1)) {
        replacement = str2;
    }
    m.appendReplacement(sb, Matcher.quoteReplacement(replacement));
}
m.appendTail(sb);
System.out.println(sb.toString());