public class PeriodicChecker extends Thread
{
    @Override
    public void run()
    {
        while(true) {
           System.out.println("Thread is doing something");
           Thread.sleep(5000);
        }
    }

}

public OtherClass {
   public static void main(String args[]) {
      Thread t = new PeriodicChecker();
      t.start();
   }
}