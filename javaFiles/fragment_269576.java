String s;// Your string
String r;// Your regexp
Pattern p = Pattern.compile(String.format(".+?(%s).*",r));
Matcher m = p.matcher(s);

if (m.find()) {
    System.out.println(m.group(1));
}