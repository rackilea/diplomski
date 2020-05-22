interface Interface1 {
   public void method();
}

public class Parent {
   protected abstract void method();
}

public class Child extends Parent implements Interface1 {
   @Override
   public void method() {
   }
   //This would be impossible if the visibility of method() in class Parent could not be increased.
}