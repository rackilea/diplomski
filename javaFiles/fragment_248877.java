Pattern p = Pattern.compile("find and replace me!");
Matcher m = p.matcher("a very long string that contains zero or more find and replace me! pattern inside");
StringBuffer sb = new StringBuffer();
boolean result = m.find();
while(result) {
    m.appendReplacement(sb, "I found you!");
    result = m.find();
}
m.appendTail(sb);
String strWithLink = sb.toString();