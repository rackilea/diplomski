String test = "<title balh> blah <title> blah>";
String target = "<title";
int index = 0;
index = test.indexOf( target, index ) + target.length();
// Index is now 6 (the space b/w "<title" and "blah"
index = test.indexOf( target, index ) + target.length();
// Index is now at the ">" in "<title> blah"