Public Class myApp
{
    static CountDownLatch countDownLatch = new CountDownLatch(1);

    static public main()
    {        
       try {
            countDownLatch.await(10000, TimeUnit.MILLISECONDS);
       } catch (InterruptedException ex) {
            // Logging
       }
    }
}