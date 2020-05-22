String str = "((created_date{[1976-03-06T23:59:59.999Z TO *]}|1))";
String patt = "\\(\\(([^{]+)\\{\\[([^ ]+) TO ([^]]+)]}\\|([01])\\)\\)";
Pattern p = Pattern.compile(patt);
Matcher m = p.matcher(str);
if (m.matches()) {
    System.out.println(m.group(1));
    System.out.println(m.group(2));
    System.out.println(m.group(3));
    System.out.println(m.group(4));
}