public class TestShutdownHook
{
    public static void main(String[] args) throws InterruptedException
    {
        Runtime.getRuntime().addShutdownHook(new Thread()
        {
            @Override
            public void run()
            {
                System.out.println("Shutdown hook ran!");
            }
        });

        while (true)
        {
            Thread.sleep(1000);
        }
    }
}