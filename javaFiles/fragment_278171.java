public class TimerLockout extends JFrame {
    //...
    public TimerLockout() {
        TimeListener listener = new TimeListener();
        timerLock = new Timer(1000, listener);
        createSecondPanel();
        // This would be helpful
        timerLock.start();
    }