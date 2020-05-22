class A implements Runnable
{
    public void run()
    {
          System.out.println("A's run method");
    }
}

class B extends A implements Runnable
{
    public void run()
    {
          System.out.println("B's run method");
    }
}

class Test
{
    public static void main(String args[])
    {
       A obj1 = new A();
       A obj2 = new B();
       B obj3 = new B();
       Runnable obj4 = new A();
       Runnable obj5 = new B();

       obj1.run(); // prints "A's run method"
       obj2.run(); // prints "B's run method"
       obj3.run(); // prints "B's run method"
       obj4.run(); // prints "A's run method"
       obj5.run(); // prints "B's run method"

    }
}