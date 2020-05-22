class BlockLevel {
  //shared among threads
  SharedResource x, y ;

  //dummy objects for locking
  Object xLock = new Object();
  Object yLock = new Object();

    public void method1() {
     synchronized(xLock){
    //access x here. thread safe
    }

    //do something here but don't use SharedResource x, y
    // because will not be thread-safe
     synchronized(xLock) {
       synchronized(yLock) {
      //access x,y here. thread safe
      }
     }

     //do something here but don't use SharedResource x, y
     //because will not be thread-safe
    }//end of method1
 }