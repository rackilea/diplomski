String s = "hello^world'this*has two tokens'";
Pattern pattern = Pattern.compile("([a-zA-Z0-9]+|'[^']*')+");
Matcher matcher = pattern.matcher(s);
while (matcher.find()) {
    System.out.println(matcher.group(0));
}