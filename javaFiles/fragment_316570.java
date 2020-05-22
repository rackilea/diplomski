class ARunnable implements Runnable{
    boolean ready = false;
    //setter for ready..
    @Override
    public void run(){
        Log.d("Runnable", "A Inside Run - WAIT");
        try{
            synchronized(this){
                if(!ready) {
                      wait();
                }
                else {
                     notifyAll(); // Now the thread which was waiting earlier, will wake-up and start resuming the execution.
                }
            }
        } catch (InterruptedException e) {}
        //Log.d("Runnable", "A Inside Run - CONTINUE");
    }
    }