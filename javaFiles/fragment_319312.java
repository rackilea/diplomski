class Test {
  void methodA() { 
    synchronized (this) {
        ...
    }
  }
  static void methodB() { 
    synchronized (Test.class) {
        ...
    }
  }
}