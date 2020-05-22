public class MyRunnable implements Runnable {

     private final String mString;
     public MyRunnable(String string) {
          mString = string;
     }

     @Override
     public void run() { 
         System.out.println(mString);
     }
}