public void func()
{
    Thread a = new Thread()
    {
        public void run()
        {
            // statements
        }
    }
    Thread b = new Thread()
    {
        public void run()
        {
            // statements
        }
    }
    a.start();
    b.start();
    a.join();  //Wait for the threads to end();
    b.join();
    new Thread()
    {
        public void run()
        {
            // statements
        }
    } .start();
    new Thread()
    {
        public void run()
        {
            // statements
        }
    } .start();
}