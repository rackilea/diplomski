YourClass myInstance = new YourClass();
 Thread thread1 = new Thread(){
    public void run(){
      myInstance.processOutbox();
    }
  }
 Thread thread2 = new Thread(){
    public void run(){
       myInstance.processOutbox();
    }
  }
thread1.start();
thread2.start();