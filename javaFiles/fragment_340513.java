boolean waitRequested = false;

void requestWait() {
  waitRequested = true;
}

void resume() {
  synchronized(this) {
    notify();
  }
}      

public void run() {      
  while( condition ) {
    try {
      //check if the thread should wait first, if not let it do a full iteration of the loop
      if( waitRequested ) {
        synchronized( this ) {
          wait();

          //resuming here so wait wouldn't be requested anymore
          waitRequested = false;
        }
      }

      //do whatever a philosopher does
    }
    catch( InterruptedException e) {
      //handle exception
    }
  }
}