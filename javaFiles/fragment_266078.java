class ThreadJoiner`
{
    private int numThreads;
    private int finishedThreads;

    public ThreadJoiner(int numThreads)
    {
        this.numThreads = numThreads;
    }

    public synchronized void updateFinishedThread() throws Exception
    {
        this.finishedThreads++;
        notify();
    }

    public synchronized void awaitThreads() throws Exception
    {
        while(this.finishedThreads < this.numThreads)
            wait();
    }   
}