class MyThread implements Runnable {

    private volatile ListenerState state;

    public synchronized void setState(ListenerState state){
       this.state = state;
    }

    @Override
    public void run() {
       while (true) {
         try {
            if (state==ListenerState.LISTENING){
              // do my job
            } else{
              Thread.sleep(300);
            }
          } catch (IterruptedException ex){
            return; 
          }
        }
    }
}