public class TestClass {

  public static List<Quake> extractEarthquakes(String earthquakeJSON) {
    ...

    // This will give an error:
    // Non-static method 'callExtract()` cannot be referenced from a static context
    doSomething();
  }

  public void doSomething() {
     ...
  }
}