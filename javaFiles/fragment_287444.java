public class threading implements Runnable
{
     public static void main(String args[])
     {
       Thread t = new Thread (new Runnable);
        t.setName("thread1");
        t.start();


     }    
      public static void print2()
      {
      System.out.println(Thread.getName());
       }
       public static void print1()
      {
      System.out.println(Thread.getName());
       print2();
       }
       public void run()
       {
      System.out.println(Thread.getName());
        print1();
       }
}