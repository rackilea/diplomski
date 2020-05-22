Class A {

    private final Object cardMonitor = new Object();
    private volatile Card myCard;

    public void keepCheck () {
        synchronized (cardMonitor) {
            while (myCard == null) {
                try {
                    cardMonitor.wait();
                } catch (InterruptedException x) {
                    // either abort or ignore, your choice
                }
            }
        }
        callAnotherMethod();
    }

    public void run () {
        synchronized (cardMonitor) {
            myCard = new Card(5);
            cardMonitor.notifyAll();
        }
    }

}