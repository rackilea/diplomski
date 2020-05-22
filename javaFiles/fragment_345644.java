class RptUpdater implements Runnable {
    public void run() {
        if( mAutoIncrement &&  counter<35){
            increment();
            repeatUpdateHandler.postDelayed( new RptUpdater(), REP_DELAY );
        } else if( mAutoDecrement && counter>10){
            decrement();
            repeatUpdateHandler.postDelayed( new RptUpdater(), REP_DELAY );
        }
    }
}