public void getSomething(){
    synchronized(this){
      // init the logic once
      if(!isReady.get()){
          SampleThread t = new SampleThread();
          t.start();                                   
      }                                   
    }
    //continue with the rest of the method       
}