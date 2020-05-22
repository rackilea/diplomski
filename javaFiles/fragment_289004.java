Pattern pattern = Pattern.compile(
    "[\\w]+|" +
    "[^\\w']|" +
    "'[^']*'");
Matcher matcher = pattern.matcher(str);
while (matcher.find()) {
    System.out.println(matcher.group());
}