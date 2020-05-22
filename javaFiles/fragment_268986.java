public void myMethod() {
  // ...

  class MyCallable<E> implements Callable<E> {
    public MyCallable(E e) {
      // Constructor
    }

    E call() {
      // Implementation...
    }
  }

  // Now you can use that "local" class (not anonymous)
  MyCallable<String> my = new MyCallable<String>("abc");
  // ...
}