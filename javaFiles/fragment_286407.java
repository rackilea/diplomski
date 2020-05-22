long nextRedraw,baseTime = System.nanoTime();
    m_Running=true;
    for (long i=0; m_Running; ++i) {
        long t0 = System.nanoTime();
        render();
        long t1 = System.nanoTime();

        nextRedraw = baseTime + i * m_RedrawTimeout;

        if(t1<nextRedraw){
            //if sleepy time is bigger than 1ms, use Thread.sleep
            if(nextRedraw-t1>1000000){
                try{
                    Thread.sleep(((nextRedraw-t1-1000000)/1000000));
                }catch(InterruptedException e){
                    Logger.logWarning("Renderer interrupted!",e);
                }
            }
            t2 = System.nanoTime();
            //do busy wait on last ms or so
            while(System.nanoTime()<nextRedraw);
        }

        long t3 = System.nanoTime();

        long frameTime = t3-t0;
        long renderTime = t1-t0;
        long sleepTime = t2-t1;
        long busyWaitTime = t3-t2;
        long fps = 1000000000/frameTime;
        System.out.format("FPS: %d\tFrame: %3.1fms\t"
                + "Render: %3.1fms\tSleep: %3.1fms\tBusyW: %3.1fms\n", 
                fps, frameTime/1000000.0, renderTime/1000000.0, 
                sleepTime/1000000.0,busyWaitTime/1000000.0);
    }