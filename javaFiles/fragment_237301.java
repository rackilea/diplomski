public void getSomething(){
    synchronized(this){
      // init the logic 
      if(!isReady){
          SampleThread t = new SampleThread();
          t.start(); 
          t.join();  // wait for the SampleThread thread termination
          isReady.set(true);           
      }         
      // execute the next only as the init thread was terminated
      if(isReady){
         //continue with the rest of the method
      }

    }     
}