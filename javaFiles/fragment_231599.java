public class testingStuff 
{
    public String func()
    {
       int i;
       String foo = "";
       for (i=0; i<3; i++ ) 
       {
          foo += "The number is "+i + " \n";
       }

      return foo;
    }

    public static void main(String[] args)  
    {
       testingStuff stuff = new testingStuff();
       String s = stuff.func();
       System.out.println(s); //this will print to console.
    }
}