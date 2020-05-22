String text = "I will come and meet you at the woods 123woods and all the woods";

List<String> tokens = new ArrayList<String>();
tokens.add("123woods");
tokens.add("woods");

String patternString = "\\b(" + StringUtils.join(tokens, "|") + ")\\b";
Pattern pattern = Pattern.compile(patternString);
Matcher matcher = pattern.matcher(text);

while (matcher.find()) {
    System.out.println(matcher.group(1));
}