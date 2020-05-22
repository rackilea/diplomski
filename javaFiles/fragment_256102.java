String line = "  test";
Pattern indentationPattern = Pattern.compile("^(\\s+)"); // changed regex
Matcher indentationMatcher = indentationPattern.matcher(line);

if (indentationMatcher.find()) {   // used find() instead of matches()
    System.out.println("Got match!");

    int indent = indentationMatcher.group(1).length(); // group 1 instead of 0
    System.out.println("Size of match: " + indent);
} else {
    System.out.println("No match! :(");
}