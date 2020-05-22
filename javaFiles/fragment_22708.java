String input = "foobar foo bar 'foobar' 'foo bar' 'foo''bar'";
Pattern pattern = Pattern.compile("'(?:[^']|'')+'|[^ ]+");
Matcher matcher = pattern.matcher(input);
while (matcher.find()) {
    String match = matcher.group();
    System.out.println(match);
}