Scanner s = new Scanner(...);
s.useDelimiter("[^\\w]");
// Find an angle bracket token, if one is next.
String token = s.findInLine("<[^.]*>");
if (token != null)
    // process angle bracket token
token = s.next(); // get next delimited token
...