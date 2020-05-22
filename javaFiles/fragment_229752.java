class Runner implements Runnable
{
  public void run()
  {
    try
    {
      synchronized(Main.main) {
        Main.main.wait();
      }
    } catch (InterruptedException e) {}
    System.out.println("Runner away!");
  }
}