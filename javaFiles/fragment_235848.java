int N = 9;
    Thread[] ring = new Thread[N];
    for(int i=0; i<N; i++)
    {
        final int ii = i+1;
        ring[i] = new Thread(()->
        {
            while(true)
            {
                LockSupport.park();   // suspend this thread
                System.out.printf("%"+ii+"d%n", ii);
                LockSupport.unpark(ring[ii%N]);  // wake up next thread
                // bug: spurious wakeup not handled 
            }
        });
    }

    for(Thread thread : ring)
        thread.start();

    LockSupport.unpark(ring[0]);  // wake up 1st thread