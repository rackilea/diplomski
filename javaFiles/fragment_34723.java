class Task implements Runnable
{
    public Task (ProgressModel progressModel)
    {
        this.pm = progressModel;
    }

    @Override
    public void run ()
    {
        // some operations
        pm.status = x;
    }
}