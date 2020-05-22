public class threading implements Runnable
{
     public static void main(String args[])
     {
       Thread t = new Thread (new Runnable);
        t.setName("thread1");
        t.start();
         print1();
         print2();

     }    
      public static void print2()
      {
      System.out.println(Thread.getName());
       }
       public static void print1()
      {
      System.out.println(Thread.getName());
       }
       public void run()
       {
      System.out.println(Thread.getName());
       }
}