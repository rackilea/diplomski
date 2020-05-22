private static class MyTimerTask extends TimerTask {
    private final Timer timer;
    private final Random random;

    public MyTimerTask(Timer timer, Random random) {
        this.timer = timer;
        this.random = random;
    }

    @Override
    public void run() {
        System.out.println("TEST");
        timer.schedule(new MyTimerTask(timer, random), random.nextInt(10000));
    }
}