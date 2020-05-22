public class Test implements Runnable{
    static Object lock = new Object();

  volatile static int  i=0;
    @Override
    public void run() {
        for(;;)
        {
            try {
                Thread t = Thread.currentThread();
                String name = t.getName();
                synchronized( lock )
                {
                    if ( i>=5000 )
                        break;
                    i++;
                    System.out.println(i+name);
                }
                //  Thread.sleep(10);
            } catch (Exception ex) {
               ex.printStackTrace();
            System.out.println("Thread is running");
            }
    }   }
    public static void main(String[] args) {
    Test t=new Test();
    Thread t1=new Thread(t);
    Thread t2=new Thread(t);
    t1.start();
      // t.run();
       t2.start();
    }
}