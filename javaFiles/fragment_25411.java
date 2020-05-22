public class Foo {
   public void doFoo() {..} // that's the method you want to use
}

public class Bar {
   private Foo foo;
   public Bar(Foo foo) {
      this.foo = foo;
   }

   public void doSomething() {
      foo.doFoo(); // here you are using it.
   }
}