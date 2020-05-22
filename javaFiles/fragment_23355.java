public class testA {

  @Test
  public void testDetails {
    ClassA a = new ClassA();
    a.setDependency(new StubClassB());
    //run your test
  }


  private class StubClassB() extends ClassB {
    public boolean saveDetails() {
      //return fake information;
    }
  }
}