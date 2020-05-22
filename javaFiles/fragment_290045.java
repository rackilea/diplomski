class MyClass
{
    Handler m_myHandler;
    Runnable m_myRunnable;

    MyClass()
    {
        m_myHandler = new Handler();
        m_myRunnable = new RUnnable()
        {
            public void run()
            {
                // do your stuff here
            }
        };
    }

    public void onclickListener(...)
    {
        // push the runnable into the message queue
        m_myHandler.post(m_myRUnnable);
    }
}