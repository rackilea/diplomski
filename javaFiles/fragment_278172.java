public TimerLockout() {
    TimeListener listener = new TimeListener();
    timerLock = new Timer(1000, listener);
    createSecondPanel();
    add(secondPanel);
    timerLock.start();
}