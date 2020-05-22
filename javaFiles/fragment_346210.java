class A {
  protected Object lock = new Object();
  protected abstract int isRunning();
  public void concreteMethod() {
    synchronized(lock) {
       //do stuff
    }
  }
}

class B extends A {
  int running_ = 0;    
  public int isRunning() {
    synchronized(lock) {
     return running_;
    }
  }
}