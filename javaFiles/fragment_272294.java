String rx = "(\\w+)=((?:<!\\[CDATA\\[.*?]]>|[^;])+)";
String s = "prop1=value1;prop2=<![CDATA[String test='1234';int i=4;]]>;prop3=value3";
Pattern pattern = Pattern.compile(rx);
Matcher matcher = pattern.matcher(s);
while (matcher.find()) {
    System.out.println(matcher.group(1) + " => " + matcher.group(2));
}