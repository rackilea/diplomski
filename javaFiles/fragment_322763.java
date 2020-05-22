private void addOne()
{
    synchronized(MyThread.class)
    {
        for (int i = 0; i < times; ++i)
        {
            Main.sharedVar ++;
        }
    }
}