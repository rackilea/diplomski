class RecurringTask implements Runnable{
    @Override
    public void run(){
        doJob();
        executor.schedule(this, delay, TimeUnit.MILLISECONDS); 
    }
}