public class C {

   private abstract class A {
       abstract void foo();
   }

   void bar() {
       new A() {
           @Override void foo() {
               // do something
           }
       }
   }
}