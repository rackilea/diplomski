public TestClass() {
    Random r = new Random();
    init(r.nextInt(),r.nextInt());
  }

  public TestClass(int testVarA, int testVarB) {
    init(testVarA, testVarB)
  }

  private void init(int testVarA, int testVarB) {
    this.testVarA = startTestVarA;
    this.testVarB = startTestVarB;
  }