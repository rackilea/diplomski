Timer timer = new Timer(interval, new Timer.ITimerCallback() {
    public void onTick() {
        //Your code to execute each interval.
    }
}
(Engine object here).registerUpdateHandler(timer);