interface CanWalk
{
  void walk();
}

class Person implements CanWalk
{
  void walk()
  {
     System.out.println("I am walking");
  }

  void f()
  {
    ///some arbitrary method
  }
}

public stativ void main(String a[])
{
   CanWalk cw=new Person();
   ((Person)cw).f();
}