public abstract class TimedBeeper {
    /** This makes the first beep always go through instantly. */
    private long lastBeep = 0;
    /** Interval in between beeps in milliseconds. */
    private long interval = 5_000;

    public void requestBeep() {
        long time = System.currentTimeMillis();
        if(lastBeep + interval < time) {
            lastBeep = time;
            beep();
        }
    }

    protected abstract void beep();
}