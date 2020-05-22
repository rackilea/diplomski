class A {
  protected abstract int isRunning();
  public synchronized void concreteMethod() {
       //do stuff
  }
}

class B extends A {
  int running_ = 0;    
  public synchronized int isRunning() {
     return running_;
  }
}