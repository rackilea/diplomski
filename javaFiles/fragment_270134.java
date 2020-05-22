private void animate()
{
    threadRunning = true;

    //Define the work as a Runnable
    Runnable r = new Runnable()
    {
        @Override
        public void run()
        {
                    int i=0;
                    //boolean doBreak = false; //Not used

                    while( true )
                    {
                        i+=1;

                        if( i == 100 )
                            break;
                    }
                    threadRunning = false; //Just before leaving
        }
    }

    //Give that work to a new thread and start the thread
    new Thread(r).run();


}