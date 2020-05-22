Object xLock = new Object(); // !!! in you main thread

....

public void writeToFile() {
    synchronized(xLock ){
      System.out.println("Thread accessed");
      //Some stuff here
      System.out.println("Thread FINISHED!");
    }       
}