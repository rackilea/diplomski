public static class BankCheck implements Delayed {
    private static final long delay = TimeUnit.NANOSECONDS.convert(2, TimeUnit.MINUTES);
    private final long created = System.nanoTime();
    private final Bank bank;

    public BankCheck(Bank bank) {
        this.bank = bank;
    }

    public Bank getBank() {
        return bank;
    }

    @Override
    public int compareTo(Delayed o) {
        if (o instanceof BankCheck) {
            BankCheck bc = (BankCheck) o;
            if (created == bc.created) {
                return 0;
            } else {
                return created < bc.created ? -1 : 1;
            }
        }

        long d = getDelay(TimeUnit.NANOSECONDS) - o.getDelay(TimeUnit.NANOSECONDS);
        if (d == 0) { return 0; }
        return d < 0 ? -1 : 1;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        long elapsed = System.nanoTime() - created;
        long remaining = delay - elapsed;
        return remaining > 0 ? unit.convert(remaining, TimeUnit.NANOSECONDS) : 0;
    }
}

BlockingQueue<BankCheck> queue = new DelayQueue<>();

Thread messageReceiver = new Thread(new Runnable() {
    @Override
    public void run() {
        for(;;) {
            if(messageReceived) {
                queue.add(new BankCheck(getBankFromLastMessage()));
            }
        }
    }
}).start();
Thread bankChecker = new Thread(new Runnable() {
    @Override
    public void run() {
        try {
            for(;;) {
                Bank b = queue.take().getBank();
                if(!hasBeenClosed(b) {
                    alertAuthorities(b);
                }
            }
        } catch(InterruptedException e) {
            // handle exception
        }
    }
}).start();