class Throttler implements TimerTask {
  final Semaphore s = new Semaphore(80);  
  final Timer timer = new Timer(true);

  Throttler() {
    timer.schedule(this, 0, 60*1000);   //schedule this for 1 min execution  
  }

  run() {  //called by timer 
    s.release(80 - s.availablePermits());
  }

  makeCall() {
    s.acquire();
    doMakeCall();
  }

}