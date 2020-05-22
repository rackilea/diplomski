public class A extends Thread {
  // spAvgData
  private final AtomicDouble spAvgData = new AtomicDouble(someDefaultValue);

  public void run() {
    while (compute) {
     // do intensive work
     // ...
      // done with work, update spAvgData
     spAvgData.set(resultOfComputation);
    }
  }

  public double getSpAvgData() {
    return spAvgData.get();
  }
}
// --------------

public class B {
  public void someMethod() {
    A a = new A();
    // after A being created, spAvgData contains a valid value (at least the default)
    a.start();
    while(read) {
      // loll around
      a.getSpAvgData();
    }
  }
}