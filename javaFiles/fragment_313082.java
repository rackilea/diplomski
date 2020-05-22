public class MultithreadEchoServer 
{
    public static void main(String[] args) throws IOException
    {
        int count=0;
        long[] ids = new long[10];

        try (ServerSocket ss = new ServerSocket(1234))
        {
            System.out.println("Listening...");

            while(true)
            {
                count++;
                Socket s = ss.accept();
                Runnable r = new MyThread(s, count);
                Thread t = new Thread(r);
                t.start();
                ids[count-1] = t.getId();

               if(Thread.activeCount() != count+1) 
                {
                    count = Thread.activeCount();
                    System.out.println("Now connected: "+count);
                }

                System.out.println("Clients connected: "+count);
                System.out.println(ids[count-1]);

            }
        }
    }         
}