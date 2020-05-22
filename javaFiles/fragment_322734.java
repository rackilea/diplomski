public void methodA()
{
    synchronized(OuterClass.this)
    {
        synchronized (this)
        {
            // ...
        }
    }
}