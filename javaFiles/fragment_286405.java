long nextRedraw,baseTime = System.nanoTime();
    m_Running=true;
    for (long i=0; m_Running; ++i) {
        long t0 = System.nanoTime();
        render();
        long t1 = System.nanoTime();

        nextRedraw = baseTime + i * m_RedrawTimeout;

        long now = System.nanoTime();
        if(now<nextRedraw){
            try{
                Thread.sleep((nextRedraw-now)/1000000);
            }catch(InterruptedException e){
                Logger.logWarning("Renderer interrupted!",e);
            }
        }

        long t2 = System.nanoTime();

        long frameTime = t2-t0;
        long renderTime = t1-t0;
        long sleepTime = t2-t1;
        long fps = 1000000000/frameTime;
        System.out.format("FPS: %d\tFrame: %3.1fms\t"
            +"Render: %3.1fms\tSleep: %3.1fms\n", 
            fps, frameTime/1000000.0, renderTime/1000000.0, sleepTime/1000000.0);
    }