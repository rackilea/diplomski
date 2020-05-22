public MyBaseClass {
  private static class Initializer {
    static {
      new TheirBaseClass();
    }

    // Doesn't actually do anything; merely provides an expression
    // to cause the Initializer class to be loaded.
    private static void ensureInitialized() {}
  }

  {
    Initializer.ensureInitialized();
  }

  // Rest of the class.
}