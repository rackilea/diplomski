public class ClassThatConsumesMyClass {
  /** Visible for testing. Override to customize MyClass instances. */
  MyClass createMyClass() {
    return new MyClass();
  }

  public ReturnValue getSpecialObjects(int n) {
    for (int i = 0; i < n; i++) {
      // Instead of calling "new MyClass()", call your method.
      MyClass myClassInstance = createMyClass();
      // ...
    }
    // ...
  }
}

public class TestForClassThatConsumesMyClass {
  ClassThatConsumesMyClass consumer;

  @Before public void createMyClass() {
    consumer = new ClassThatConsumesMyClass() {
      @Override MyClass createMyClass() {
        MyClass myInstance = Mockito.mock(MyClass.class);
        Mockito.when(myInstance.getSpacing()).thenReturn(0);
        return myInstance;
      }
    }
  }

  // Test as usual, now that you've mocked every newly-created
  // instance of MyClass in your consumer.
}