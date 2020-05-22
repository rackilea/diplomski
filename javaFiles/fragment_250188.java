Runnable command = new Runnable() {
    public void run() {
        System.out.println("executed");
    }
};
scheduler.scheduleAtFixedRate(command, 0, 1, TimeUnit.SECONDS);
scheduler.scheduleAtFixedRate(command, 0, 1, TimeUnit.SECONDS);