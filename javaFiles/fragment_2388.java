abstract class A {
      public abstract void doStuff();       
    }

class B extends A    {
  static List<String>myArray = new LinkedList<String>();

  public abstract void doStuff() {
      // do B stuff
  }

}

class C extends A  {
  static List<String>myArray = new LinkedList<String>();
  public abstract void doStuff() {
      // do C stuff
  }

}