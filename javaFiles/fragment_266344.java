public void start()
{
    Task t = new Task();
    ScheduledFuture sf = ThreadPoolManager.getInstance().scheduleAtFixedDelay(t, 1000, 1000);
    t.setFuture(sf);
}

class Task implements Runnable {

    private int i = 0;
    private ScheduledFuture sf;

    public void setFuture(ScheduledFuture sf) {
        this.sf = sf;
    }

    public void run() {
        i++;
        if(i==5)
            sf.cancel(true);
    }
}