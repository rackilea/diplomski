private void enable(){
            exec = new ScheduledThreadPoolExecutor(1); // Creates a NEW scheduler and takes the place of the old one. But the old one still exists and does its duty!
            long period = 2000; 
            exec.setExecuteExistingDelayedTasksAfterShutdownPolicy(false);
            exec.setContinueExistingPeriodicTasksAfterShutdownPolicy(false);
            sf = exec.scheduleAtFixedRate(new SwitchCheck(), 0, period, TimeUnit.MILLISECONDS);
}