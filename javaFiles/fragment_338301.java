public class Foo {
   private String bar; // this variable stays null

   public Foo() {
      initialize();
   }

   public void intialize() {
      // this initialize a *local* variable
      String bar = "baz";
   }
}