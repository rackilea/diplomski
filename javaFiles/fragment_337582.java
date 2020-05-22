Runnable mHandlerTask = new Runnable()
{
    @Override
    public void run() {
        new makeRequest().execute();
        mHandler.postDelayed(mHandlerTask, 3000); //remove this line!
    }
};