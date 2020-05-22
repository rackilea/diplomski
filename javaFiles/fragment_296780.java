String input = "(s(j1) | f(j2) | d(f3) | t(f4) | e(f5) = 5) & v(g) = \"0\"";
String regex = "\\(([^(]+?)\\)";
Matcher matcher = Pattern.compile(regex).matcher(input);
while (matcher.find()) {
    System.out.println(matcher.group(1));
}