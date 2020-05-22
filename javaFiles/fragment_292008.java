public class MonitorObject{
}

public class MyWaitNotify{

  MonitorObject myMonitorObject = new MonitorObject(); //To be used for synch

  public void doWait(){
    synchronized(myMonitorObject){
      try{
        myMonitorObject.wait(); // Wait until the notify method is called by another thread
      } catch(InterruptedException e){...}
    }
  }

  public void doNotify(){ //Notify waiting threads that they can continue
    synchronized(myMonitorObject){
      myMonitorObject.notify();
    }
  }
}