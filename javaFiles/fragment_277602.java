String regex = "(?:^group |\\G(?!^))(\\S+)(?:\\s+|$)";
String string = "group g1 l1 l2 l3 g2 g3.l1";

Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
Matcher matcher = pattern.matcher(string);

while (matcher.find()) {
    System.out.println(matcher.group(1));
}