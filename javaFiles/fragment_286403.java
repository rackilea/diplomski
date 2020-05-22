private final ScheduledExecutorService scheduler 
    = Executors.newScheduledThreadPool(1);

//handle for killing the process
private ScheduledFuture<?> handle = null;

//meassuring actual time between redraws
private long lastRenderStart = 0;

//start will fire off new scheduler at desired 60Hz
@Override
public synchronized void start() {
    handle = scheduler.scheduleAtFixedRate(this, 
        100000000, m_RedrawTimeout, TimeUnit.NANOSECONDS);
}

public void kill(){
    if(handle!=null){
        handle.cancel(true);
    }
}

@Override
public void run(){
    //meassured render routine
    long t0 = System.nanoTime();
    render();
    long t1 = System.nanoTime();

    System.out.format("render time %.1fms\t\tframe time %.1fms\n",
        ((t1-t0)/1000000.0d),
        ((t0-lastRenderStart)/1000000.0d));
    lastRenderStart = t0;
}