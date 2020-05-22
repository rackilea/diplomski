public class MyCallThread extends Thread {

   private int paramOne;
   private int paramTwo;

   public MyCallThread (Runnable runnable, int paramOne, int paramTwo){
     super(runnable);
     this.paramOne = paramOne;
     this.paramTwo = paramTwo;
   }

   public void run(){
       ... 
       objComando.setInt(1, paramOne);
       ...

   }
}