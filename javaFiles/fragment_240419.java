// Instantiate TestClass1 as a member of TestClass2
public TestClass2 {
    private TestClass1 one = new TestClass1();
    public void testSomethingAndSomethingElse1() {
         one.testSomething();
    }
}