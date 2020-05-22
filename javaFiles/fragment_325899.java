private Timer.Task myTimerTask = new Timer.Task() {
    @Override
    public void run() {
      doSmth();
    }
};

public void startTimer(){
    Timer.schedule(myTimerTask, 1f, 1f);
}