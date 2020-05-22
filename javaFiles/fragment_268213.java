Pattern pattern = Pattern.compile("\"([a-zA-Z]*)\"");
Matcher matcher = pattern.matcher(input);

while(matcher.find()) {
    System.out.println(matcher.group(1));
}