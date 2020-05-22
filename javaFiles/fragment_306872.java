private Runnable tickThread = new Runnable() 
{
    public void run() 
    {
        if(!running)
            return;