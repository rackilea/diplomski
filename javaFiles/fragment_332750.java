public abstract class SomeObject {
   public Object(){
       objectStart();
   }
   private void objectStart(){
       // do something general
       start();
   }

   public abstract void start();
}