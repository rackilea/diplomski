class ShowTask extends TimerTask {
    JLabel label;
    Random generator = new Random();
    //HideTask hTask;
    //java.util.Timer timer = new java.util.Timer();
    long period = 500; // ms

    public Task(JLabel pLabel){
        label = pLabel;
        //hTask = new HideTask(pLabel);
    }

    public void run(){
        int i = generator.nextInt(100);
        setLabel(i);
        // if you want it to go SHOW HIDE SHOW HIDE instead of SHOW SHOW SHOW then:
        //timer.schedule(hTask, period);
        // just wait
        Thread.sleep(period);
        hideLabel();
    }

    void setLabel(int i){
        ...
    }
}
/*
class HideTask extends TimerTask {
    JLabel label;

    public HideTask(JLabel pLabel){
        label = pLabel;
    }

    public void run(){
        hideLabel();
    }

    void hideLabel(){
        ...
    }
}
*/