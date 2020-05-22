new MyTimer().schedule(new TimerTask() {
    @Override
    public void run() {
        System.out.println("Hello");
    }
}, 1000, 1000);