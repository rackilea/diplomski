String x = "xyz@hotmail.com";
String y = "xyz@outlook.com";
Pattern p = Pattern.compile(".+@([^.]+)\\.");
Matcher m = p.matcher(x);
if (m.find()) {
    System.out.println("found: " + m.group(1));
}
m = p.matcher(y);
if (m.find()) {
    System.out.println("found: " + m.group(1));
}