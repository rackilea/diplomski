class TestClass {
    MyClassFactory factory;
    public TestClass(MyClassFactory factory) {
        this.factory = factory;
    }

    public List<String> test(String a, String b, String c, String d) throws IOException {
      MyClass myClass = factory.Create(functionName);
      int outputNum = myClass.getOutputTableArgsSize();
      List<String> list = new ArrayList<String> ();

      //... and some more code based on outputNum value.

      return list;
    }
}