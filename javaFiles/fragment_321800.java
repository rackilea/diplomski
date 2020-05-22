public void writeToFile() {
    synchronized(this){
      System.out.println("Thread accessed");
      //Some stuff here
      System.out.println("Thread FINISHED!");
    }       
  }