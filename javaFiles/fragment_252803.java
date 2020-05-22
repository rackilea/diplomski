public void testUncaughtExceptionhandler()
{
  Thread testThread = new Thread()
  {
    public void run()
    {
      throw new RuntimeException("Expected!");
    }
  };

  testThread.start();
  testThread.join();
}