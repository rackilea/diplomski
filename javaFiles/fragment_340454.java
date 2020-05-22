public class ThreadTest
{
   public static void main(String [] args)
   {
      MyThread t1 = new MyThread(0, 3, 300);
      MyThread t2 = new MyThread(1, 3, 300);
      MyThread t3 = new MyThread(2, 3, 300);

      t1.start();
      t2.start();
      t3.start();
   }
}