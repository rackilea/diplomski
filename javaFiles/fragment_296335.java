Pattern p = Pattern.compile("([A-Z])(\\d+)((?:[A-Z][a-z]+)+)");
String str = "X89SuperJavaJavaX89SuperJava";
Matcher m = p.matcher(str);
while (m.find()) {
    System.out.println(m.group(1));
    System.out.println(m.group(2));
    System.out.println(m.group(3));
}