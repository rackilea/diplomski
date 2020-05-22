class MyClass {
  //1) initialized/called once
  public final static float[] TABLE = MyClassInitializer.buildSomething();

  public static float[] myMethod(float[] args) {
    //2) non-strict
  }
}

//3) doesn't "pollute" the MyClass API
class MyClassInitializer {
  strictfp [static] float[] buildSomething() { //4) strictfp here or on the class
    //TODO: return something
  }
}