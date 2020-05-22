class DelayedMessage implements Delayed {

    long endOfDelay;
    Date requestTime;
    String message;

    public DelayedMessage(String m, int delay) {
        requestTime = new Date();
        endOfDelay = System.currentTimeMillis()
                + delay;
        this.message = m;
    }

    public long getDelay(TimeUnit unit) {
        long delay = unit.convert(
                endOfDelay - System.currentTimeMillis(),
                TimeUnit.MILLISECONDS);
        return delay;
    }

    public int compareTo(Delayed o) {
        DelayedMessage that = (DelayedMessage) o;
        if (this.endOfDelay < that.endOfDelay) {
            return -1;

        }
        if (this.endOfDelay > that.endOfDelay) {
            return 1;
        }
        return this.requestTime.compareTo(that.requestTime);
    }

    @Override
    public String toString() {
        return message;
    }
}