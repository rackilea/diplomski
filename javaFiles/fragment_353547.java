public static void main(String[] args) {

    CountDownLatch cdl = new CountDownLatch(1);
    Timer timer = new Timer();
    timer.schedule(new MyTimerTask(new TimerDone() {
        @Override
        public void timerDone() {
            //execute this code after timer finished
            System.out.println("finish");
        }
    }), 3000);
}

public static interface TimerDone {
    public void timerDone();
}

private static class MyTimerTask extends TimerTask {

    private TimerDone done;

    public MyTimerTask(TimerDone done) {
        this.done = done;
    }

    @Override
    public void run() {
        System.out.println("inside timer");            
        done.timerDone();
    }

}