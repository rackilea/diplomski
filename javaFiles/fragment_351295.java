String example = "Hello.  That was a double space. That was a single space."
String formatted = example.replace("  ", " !@#!@#");
String [] split = formatted.split(" ");
for(int i = 0; i < split.length; i++)
{
  split.replace("!@#!@#", " ");
}
// Recombine your splits?