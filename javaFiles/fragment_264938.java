Pattern pat1 = Pattern.compile("aaa(.*)ccc.*ddd");
Pattern pat2 = Pattern.compile("foo|bar");

Matcher m1 = pat1.matcher(source);
String foobar;
if (m1.matches()) {
    Matcher m2 = pat2.matcher(m1.group(1));
    if (m2.find()) {
        foobar = m2.group(0);
    } else {
        foobar = null;
    }
}