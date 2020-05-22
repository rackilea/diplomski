Timer timer = new Timer(false);

TimerTask firstTask = new TimerTask() {
    @Override
    public void run() {
        System.out.println("Hitme");
    }
};

timer.scheduleAtFixedRate(firstTask, 5000, 5000);
timer.schedule(new TimerTask() {
    @Override
    public void run() {
        firstTask.cancel();
    }
},45000);