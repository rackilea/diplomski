public class RuntimeTest
{
  public static void main(String[] a)
  {
    Thread t = new Thread()
    {
      public void run()
      {
        throw new RuntimeException("Testing unhandled exception processing.");
      }
    };
    t.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler()
    {
      public void uncaughtException(Thread t, Throwable e)
      {
        System.err.println(t + "; " + e);
      }
    });
    t.start();
  }
}