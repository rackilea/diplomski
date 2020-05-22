public class ManagedThreads {
   private final static ExecutorService ex = Executors.newFixedThreadPool(10);

   public static void myMethod(final int i) {
      ex.execute(new Runnable() {
         public void run() {
             // do every tenth task.
             for(int j = i; j < 1000000000; j += 10) {
                 // method body
             }
         }
      });
   }

   public static void main(String[] args) {
      for (int i = 0; i < 10; ++i)
         myMethod(i);
   }
}