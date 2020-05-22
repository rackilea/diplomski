// using _var_ because I'm too lazy to look up the return types of the methods
var x1 = this.getClass().getResource("../Card/AtlanticAve.jpg");
if (x1 == null)
{
   System.out.println("Can't find my resource");
}