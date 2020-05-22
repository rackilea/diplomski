{
    @Override
    public void onClick(View view)
    {
        if (myThread.isAlive())
        {
            // Thread is alive, do not launch again
        }
        else
        {
            // Thread is not running so call method...
            getPicture();
        }
    }
});