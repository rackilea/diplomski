timer.scheduleAtFixedRate(new TimerTask() {
    @Override
    public void run() {
        System.out.println("it only prints this once");
    }
}, 100, 100);