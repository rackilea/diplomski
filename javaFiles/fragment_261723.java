private volatile Thread runner;

public synchronized void startThread(){
  if(runner == null){
    runner = new Thread(this);
    runner.start();
  }
}

public synchronized void stopThread(){
  if(runner != null){
    Thread moribund = runner;
    runner = null;
    moribund.interrupt();
  }
}

public void run(){
  while(Thread.currentThread() == runner){
    //do stuff which can be interrupted if necessary
  }
}