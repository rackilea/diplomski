String input = "123+34/123(23*12)/100";
Pattern pattern = Pattern.compile("\\d+|[\\+\\-\\/\\*\\(\\)]");
Matcher matcher = pattern.matcher(input);
while(matcher.find()) {
    System.out.println(matcher.group());
}