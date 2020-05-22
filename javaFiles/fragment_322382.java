public void a()
{
  new Thread(
    new Runnable()
    {
      @Override
      public void run()
      {
        try
        {
          System.out.println("A: I am going to sleep");
          Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
          e.printStackTrace();
        }

        synchronized(MyClass.this)
        {
          System.out.println("A: I slept one full day. Feels great.");
          System.out.println("A: Hey B, wake up!");
          MyClass.this.notifyAll();
        }
      }
    }
  ).start();
}

public void b()
{
  new Thread(
    new Runnable()
    {
      @Override
      public void run()
      {
        synchronized(MyClass.this)
        {
          System.out.println("B: I am  going to sleep. A, please wake me up.");

          try
          {
            MyClass.this.wait();
          }
          catch (InterruptedException e)
          {
            e.printStackTrace();
          }

          System.out.println("B: Thank you A for waking me up!");
        }
      }
    }
  ).start();
}