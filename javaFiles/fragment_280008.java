class Test1 {

  public static void main(String... args) {
    loadClass(formula);
  }

  static void loadClass(location) {
    ClassLoader loader = new ClassLoader();
    Class formula = loader.load(location);
    Class test1 = loader.load(Test1);
    // ...
    Method compute = test1.getMethod("compute");
    compute.invoke(test1, formula);
  }

  static void compute(formula) {
    print formula;
  }
}