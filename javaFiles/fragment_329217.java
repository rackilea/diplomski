public class A
{
   protected String name;

   public void printName()
   {
      System.out.println(name);
   }
}

public class B extends A
{
    public B()
    {
        name = "b";
    }
}

public class Main 
{
    public static void main(String [] args)
    {
       B b = new B();
       b.printName();
    }
}