String s = "BBC  The Other [lough] The kough there are [link] [hashTag]";
String p = "(\\[(?:link|hashTag|lough)])|\\p{Alnum}+";
Matcher m = Pattern.compile(p).matcher(s);
StringBuffer sb = new StringBuffer();
while (m.find()) {
    if (m.group(1) != null)
        m.appendReplacement(sb, m.group(1));
    else
        m.appendReplacement(sb, "[englishWord]");
}
m.appendTail(sb); 
System.out.println(sb);