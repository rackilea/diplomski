//                           | named group "stuff" matches 0 or more characters
//                           |           | named group "ellipses" 3 consecutive dots
//                           |           |                     | non grouped stuff
Pattern p = Pattern.compile("(?<stuff>.*)(?<ellipses>\\.\\.\\.).*");
String input = "blah ... blah";
Matcher m = p.matcher(input);
if (m.find()) {
    // printing back reference to named group "stuff"
    System.out.println(m.group("stuff"));
    // printing back reference to named group "ellipses"
    System.out.println(m.group("ellipses"));
}