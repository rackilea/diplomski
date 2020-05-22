String foo = "foo bar bar";
String toLookUp = "bar";
int initialPosition = foo.indexOf(toLookUp);
while(initialPosition != -1)
{
     System.out.println("Initial Position: " + initialPosition + " end: " + initialPosition + toLookUp.length);
     initialPosition = foo.indexOf(toLookUp, initialPosition + toLookUp.length;
}