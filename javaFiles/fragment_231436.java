public class App
{
    public static void main(String[] args) throws FileNotFoundException, InterruptedException, ExecutionException 
    {
        PrintStream oldErr = System.err;
        System.setErr(new PrintStream(new File("test")));

        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        List<Future<?>> fList = new LinkedList<Future<?>>();
        for (int i = 0; i < 5; i++)
        {
            fList.add(threadPool.submit(new Runnable() {

                @Override
                public void run()
                {
                    System.err.println("This is to the err stream");
                }

            }));
        }

        for (Future<?> f : fList)
        {
            f.get();
        }

        threadPool.shutdown();

        System.setErr(oldErr);
        System.err.println("This is to the err stream");
    }
}