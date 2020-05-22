class MyActivity ... implements CompletionCallback {
...

  void doTheThing() {
    MyClass someMyClass = new MyClass();
    someMyClass.doSomething(this);
  }

  @Override 
  void finish() { ...