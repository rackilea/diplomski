String hasPageNumber = "<Line><![CDATA[AB1234 Date 02/31/18                       Company  1234 Very Big Company              USD                               Page    1]]></Line>";
String noPageNumber = "<Line><![CDATA[1234AB1234    -  1234-       Page Cash Savings]]></Line>";
Pattern p = Pattern.compile("Page\\s+\\d+");
Matcher m = p.matcher(hasPageNumber);
if (m.find()) {
    System.out.printf("Found: %s%n", m.group());
}
else {
    System.out.println("Not found");
}
m = p.matcher(noPageNumber);
if (m.find()) {
    System.out.printf("Found: %s%n", m.group());
}
else {
    System.out.println("Not found");
}