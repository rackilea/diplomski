public class Foo{
   public Bar methodA()
   {
       // ...
       return new Bar();
   }

   public class Bar {

      private Bar() {}; // only methodA can create a Bar object

      public void methodB(){}
      public void methodC(){}

  } 
}