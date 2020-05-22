String match = "a.abc";
if (match.matches(".*(?!e)[a-zA-Z0-9]\\.(.*)")) {
    System.out.println("match");
}
String noMatch = "e.abc";
if (noMatch.matches(".*(?!e)[a-zA-Z0-9]\\.(.*)")) {
    System.out.println("no match");
}