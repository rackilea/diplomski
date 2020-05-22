while(frame.value.equalsIgnoreCase(""))
{
    try
    {
        System.out.println("waiting...");
        Thread.sleep(1000);
    }
    catch(InterruptedException ie)
    {
    System.out.println("interrupted");
    }
}