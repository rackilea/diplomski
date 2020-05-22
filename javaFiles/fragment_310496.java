while(!isDone) {
  try {
    synchronized(this) {
      while(!condition) wait();
      if(isDone) break;// skip doSomeVeryLongRunningTask()
      condition=false;
    }
  } catch(InterruptedException e) {
    e.printStackTrace();
  }
  doSomeVeryLongRunningTask();
}