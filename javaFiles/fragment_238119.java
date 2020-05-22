class MyClass {

    private synthetic MyClass(String aParam, $SomeType ignored) {
        System.out.println("constructor called");
    }

    @Inject
    public MyClass(String aParam) {
      this(aParam, null);
      // Instrumentation logic.
    }
}