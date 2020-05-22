public class Test
{
   private final Object lock = new Object();
   private Object obj;

   public void init()
   {
       service.registerListener(new InnerTest());
   }

   public void readObj()
   {
       synchronized(lock){
           // read obj here
       }
   }

   private class InnerTest implements Listener
   {
       public void updateObj()
       {
           synchronized(Test.this.lock){
               Test.this.obj = new Object();
               // change the obj
           }
       }
   }
}