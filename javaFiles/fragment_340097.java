class MyClass {
  private Object object = new Object();

  public synchronized void synchronizedOnThis1() {
    ...
  }
  public void synchronizedOnThis2() {
    synchronized(this) {
      ...
    }
  }
  public void synchronizedOnPrivateObject() {
    synchronized(object) {
      ...
    }
  }
}

class ExternalParty {
  public void messUpLocks() {
    final MyClass myObject = new MyClass();
    synchronized(myObject) {
      Thread otherThread = new Thread() {
        public void run() {
            myObject.synchronizedOnThis1();
        }
      };
      otherThread.start();
      // do a lengthy calculation - this will block the other thread
    }
  }
}