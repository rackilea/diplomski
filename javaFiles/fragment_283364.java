String ok = "CPI WEIGHTS 05.1.2 : CARPETS & OTHER FLOOR COVERINGS";
String notOk = "CPIH INDEX 05.2 : HOUSEHOLD TEXTILES 2005=100";
Pattern p = Pattern.compile("(\\d{1,2}(\\.|\\s)){3}");
Matcher m = p.matcher(ok);
while (m.find()) {
    System.out.printf("Found: %s%n", m.group());
}
m = p.matcher(notOk);
while (m.find()) {
    System.out.printf("Found: %s%n", m.group());
}