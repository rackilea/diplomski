public class A{
   public static void foo(C input) {
       input.foo();
   }
}

public class B implements C {
   public void bar() {
       // I make the change here and then trigger a new build
       A.foo(this);
   }
}

public interface C {
   void bar();
}