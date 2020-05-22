class TimerThread extends Thread {

    TimerTask scanTask;
    Timer t = new Timer();

    @Override
    public void run() {
        Looper.prepare();
        scanTask = new TimerTask() {
            public void run() {
                System.out.println("timer test");
            }
        };

        t.schedule(scanTask, 0, 5000);

        CountDownTimer waitTimer;
        waitTimer = new CountDownTimer(20000,300) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                t.cancel();
                System.out.println("Timer stopped");
            }
        }.start();

        Looper.loop();
    }
}