class Foo {

   public void methodA () {
      synchronized (this) {
         doSmth ();
      }
   }

   public void methodB () {
      synchronized (this) {
         doSmthElse ();
      }
   }

}