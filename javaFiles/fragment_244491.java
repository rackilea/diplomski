public class Foo {
   int retval, itemp = 100;


   public static void main(String[] args) {
      Foo foo = new Foo();
      System.out.println(foo.myMethod());
   }

   public int myMethod() {
      retval = itemp;
      {
         int retval, itemp = 75;
         retval = itemp;
      }
      return retval;
   }
}