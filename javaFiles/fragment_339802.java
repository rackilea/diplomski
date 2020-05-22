public class JavaApplication1 extends Test.SubClass {

   public JavaApplication1() {
      new Test() {}.super();
   }

   public static void main(String[] args) {
      new JavaApplication1();
   }
}

abstract class Test {
   public Test() {
      System.out.println("from Test");
   }

   public abstract class SubClass extends Test {
      public SubClass() {
         System.out.println("from SubClass");
      }
   }
}