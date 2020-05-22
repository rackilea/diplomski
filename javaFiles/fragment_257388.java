public class P2POrRMITimer implements Runnable {
    private Runnable p2p;
    private Runnable rmi;
    private ObjectWhichContainsTheFlag flagContainer;

    public P2POrRMITimer(Runnable p2p, 
                         Runnable rmi, 
                         ObjectWhichContainsTheFlag flagContainer) {
        this.p2p = p2p;
        this.rmi = rmi;
        this.flagContainer = flagContainer;
    }

    @Override
    public void run() {
        if (flagContainer.isRmi()) {
            rmi.run();
        }
        else {
            p2p.run();
        } 
    }
}

...

scheduler.scheduleAtFixedRate(new P2POrRMITimer(new P2PTimer(player),
                                                new RMITimer(player),
                                                this),
                              1, 
                              60, 
                              TimeUnit.SECONDS);