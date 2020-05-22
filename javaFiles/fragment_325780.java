Pattern rgx = Pattern.compile("(?<=Broker)\\R((?:.*\\R){1,7})");
// Or, 
// Pattern rgx = Pattern.compile("(?d)(?<=Broker)\n((?:.*\n){1,7})");
Matcher mtch = rgx.matcher(inp);
if (mtch.find()) {
    String result = mtch.group();
    System.out.println(result.trim());
}