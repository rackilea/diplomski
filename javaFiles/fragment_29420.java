class Foo {

   static class Bar {
      private final Foo $foo;

      Bar(Foo foo) {
          this.$foo = foo;
      }    

      public void someMethod() {
          $foo.doSomething();
      }
   }
}