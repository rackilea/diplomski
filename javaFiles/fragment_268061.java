String yourUrlString = "http://BLABLABLA?qUERY=sth&macro1=${MACRO_STR1}&macro2=${macro_str2}";

Pattern p = Pattern.compile("\\$\\{[^}]+\\}|[A-Z]");
Matcher m = p.matcher(yourUrlString);

StringBuffer sb = new StringBuffer();
while(m.find()){
    String match = m.group();
    if (match.length() == 1){
        m.appendReplacement(sb, match.toLowerCase());
    } else {
        m.appendReplacement(sb, Matcher.quoteReplacement(match));
    }
}
m.appendTail(sb);
String replaced = sb.toString();
System.out.println(replaced);