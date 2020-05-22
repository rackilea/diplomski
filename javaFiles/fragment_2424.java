long REFRESH_TIMEOUT=100;
Timer timer = null;
MyTask myTask = null;
public void listenToEvent(Event event, long timestamp){
    if(event.getName().equals("ADD")){
        timer = new Timer();
        timer.schedule(myTask = new MyTask(event), REFRESH_TIMEOUT);
    }
    if(event.getName().equals("DELETE")){
        if (myTask!=null && !myTask.expired){
            processRefresh(event);
            timer.cancel();
        }else{
            processDelete(event);
        }
    }
}

private static class MyTask extends TimerTask {
    Event event;
    boolean expired;
    public MyTask(Event event){
        this.event=event;
    }
    @Override
    public void run() {
        expired=true;
        processAdd(event);
    }
}

private void processAdd(Event e){
    ...
}
private void processDelete(Event e){
    ...
}
private void processRefrsh(Event e){
    ...
}