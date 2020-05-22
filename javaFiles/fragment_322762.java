private void addOne()
{
    synchronized(this)
    {
        for (int i = 0; i < times; ++i)
        {
            Main.sharedVar ++;
        }
    }
}