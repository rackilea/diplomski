public class Tests  {
   public static void main(String[] args) throws Throwable {
       String value = "Hello";

       Runnable runnable = new Runnable() {
           @Override
           public void run() {
               System.out.println(value);
           }
       };
   }
}