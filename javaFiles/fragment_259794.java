public class Main 
{
    public static void main(String args[])
    {
        new Main().run();
    }

    private void run() 
    {
        Semaphore semaphore = new Semaphore(5, true);
        for (int i = 0; i<6; i++)
        {
            try
            {
                semaphore.acquire(1);
                new TestThread(i, semaphore).start();
            }
            catch (final InterruptedException e) {}

        }
    }

    class TestThread extends Thread
    {
        private Semaphore semaphore;
        private Integer id;

        TestThread(final Integer id, final Semaphore semaphore)
        {
            this.semaphore = semaphore;
            this.id = id;
        }

        @Override
        public void run()
        {
            System.out.println("Thread " + id + " has started.");
            try
            {
                Thread.sleep(5000);
            }
            catch (final InterruptedException e) {}
            System.out.println("Thread " + id + " has stopped.");
            semaphore.release(1);
        }
    }
}