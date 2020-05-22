private final static int INTERVAL = 1000 * 60 * 1;
Handler mHandler = new Handler();

Runnable mHandlerTask = new Runnable()
{
    @Override 
    public void run() {
         doSomething();
         mHandler.postDelayed(mHandlerTask, INTERVAL);
    }
};