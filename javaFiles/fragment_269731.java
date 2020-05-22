//Multiplies by 100,000 rather than divides.
sleep = ((int)(period*1000) - (System.nanoTime() - startTime)*100000);
//Note that sleep here is a very small number minus a very large number: probably negative.

try{
  if(sleep > 0){//If positive, sleep
    Thread.sleep(sleep);
  } else{//throws an error in all other cases.
    System.err.println("Warning: program runtime exceeded period");
  }
}catch(Exception ex){}//Empty exception handling poorly handles the thread.sleep() Exception requirement.