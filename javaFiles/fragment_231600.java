public void func()
{
   int i;
   String foo = "";
   for (i=0; i<3; i++ ) 
   {
      foo = "The number is " + i;
      System.out.println(foo);
   }
}

public static void main(String[] args) 
{
   testingStuff stuff = new testingStuff();
   stuff.func();
}