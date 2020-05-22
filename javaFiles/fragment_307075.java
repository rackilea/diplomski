public Runnable createTask = new Runnable() {
    @Override
    public void run() {
        // Do What Ever You Need 
        scheduler.schedule(this, nextDayOfTask, TimeUnit.DAYS);
    }
};