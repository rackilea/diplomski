public class TimerThingy{
    HashMap<UUID,TimerTask> tasks = new HashMap<UUID,TimerTask>();
    Timer timer = new Timer();

    public UUID createAndStartTimer(final Runnable task, Date when){
        TimerTask timerTask = new TimerTask(){
            public void run(){
                task.run();
            }
        }
        timer.schedule(TimerTask timerTask, Date when);
        UUID id = UUID.randomUUID(); 
        tasks.put(id, t);
        return id;
    }

    public void cancelTimer(UUID id){
        tasks.get(id).cancel();
    }

}