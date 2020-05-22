public void run(){
    while(Thread.currentThread() == runner){
      //do stuff which can be interrupted if necessary

      if(/*fatal error*/){
        stopThread();
        return; //optional in this case since the loop will exit anyways
      }
    }
  }