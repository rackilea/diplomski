class Bar implements SomeMethod {
   private final SomeMethod foo;

   public Bar(SomeMethod foo) {
     this.foo = foo;  
   }

   public void doSomething() { foo.doSomething(); }
   public void doSomethingElse() { // do something else! }
}