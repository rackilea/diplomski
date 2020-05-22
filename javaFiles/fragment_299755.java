// Non capturing open tag. Non-capturing mean it won't be included in result when we match it against some text.
String open = "(?<=\\{\\[CONTAINER\\]\\})"; 

// Content between open and close tag.
String inside = ".*?"; 

// Non capturing close tag.
String close = "(?=\\{\\[/CONTAINER\\]\\})";

// Final regex
String regex = open + inside + close;

String text = "<html>..."; // you string here

// Usage
Matcher matcher = Pattern.compile(regex, Pattern.DOTALL).matcher(text);
while (matcher.find()) {
    String content = matcher.group().trim();
    System.out.println(content);
}