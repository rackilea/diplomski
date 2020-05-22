class MyThread extends Thread {

    private volatile boolean running = true; // Run unless told to pause

    ...

    @Override
    public void run()
    {
        for(int i=0 ; ; i++)
        {
            // Only keep painting while "running" is true
            // This is a crude implementation of pausing the thread
            while (!running)
                yield;

            area.setText(i+"");
    }

    public void pauseThread() throws InterruptedException
    {
        running = false;
    }

    public void resumeThread()
    {
        running = true;
    }

}