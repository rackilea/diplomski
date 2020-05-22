String argument = "#a1^b2";
Pattern pattern = Pattern.compile("[a-zA-Z]|[0-9]|\\s|(.)"); // or "[a-zA-Z0-9\\s]|(.)"
Matcher matcher = pattern.matcher(argument);

while(matcher.find()) {                           // find all matching characters
    System.out.println(matcher.group(1) == null);