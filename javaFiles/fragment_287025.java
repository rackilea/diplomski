// Compile a regular expression: A hash followed by any number of characters
Pattern p = Pattern.compile("#(.*)");

// Match input data
Matcher m = p.matcher("test#1");

// Check if there is a match
if (m.find()) {

  // Get the first matching group (in parentheses)
  System.out.println(m.group(1));
}