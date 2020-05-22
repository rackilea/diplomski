public void run()
      {
        for(int i = 0; i <= 100; i++)
        {
        if(i==100)
        {
            System.out.println(Thread.currentThread().getName() +" : before setting value 100th time : " + System.currentTimeMillis());
        }
          Value.value = Thread.currentThread().getName() + "--" + i;
          if(i==100)
        {
            System.out.println(Thread.currentThread().getName() +" : after setting value 100th time : " + System.currentTimeMillis());
        }
        }
        System.out.println(Thread.currentThread().getName() +" : before printing : " + System.currentTimeMillis());
        Value.printValue();
        System.out.println(Thread.currentThread().getName() +" : before exiting : " + System.currentTimeMillis());
        System.exit(0);
      }


class Value
{
  static String value = null;

  public static void printValue()
  {
    System.out.println(Thread.currentThread().getName() + " : value : " + value + " : " + System.currentTimeMillis());
  }
}