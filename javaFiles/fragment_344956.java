Pattern p = Pattern.compile("((?:(?:'[^']*')|[^;])*);";);
Matcher m = p.matcher(s);
int cnt = 0;
while (m.find()) {
    System.out.println(++cnt + ": " + m.group(1));
}