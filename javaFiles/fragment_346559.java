Thread thread = new Thread(new Runnable()
{
    @Override
    public void run() 
    {
        try 
        {
             DownloadPost();
        } 
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
});

thread.start();