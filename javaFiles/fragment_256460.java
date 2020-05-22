// String to be scanned to find the pattern.
String line = "My name is Oz, the great and powerful";
String pattern = "(My name is )(.*)(,)(.*)";

// Create a Pattern object
Pattern r = Pattern.compile(pattern);

// Now create matcher object.
Matcher m = r.matcher(line);
if (m.find( )) {
   String name = m.group(2);
}