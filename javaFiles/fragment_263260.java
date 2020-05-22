class repeatTask extends Thread
{
    int repeatTime;

    public repeatTask(int repeatTime)
    {
        this.repeatTime = repeatTime;
    }

    public void run()
    {
        while(true)
        {
            try {
                Thread.sleep(repeatTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            /* Some action codes here*/
        }
    }
}