Pattern pattern = Pattern.compile("(.*):.*"); // <-- parentheses here
String  name = "abc:def";
Matcher matcher = pattern.matcher(name);

if (matcher.find()) {
    String group = matcher.group(1);
    System.out.println(group); // prints "abc"
}