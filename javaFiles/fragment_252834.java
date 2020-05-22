public class TestClass {
    @Test
    public void test() {
        Person v = new TestPerson();
        Person person2 = SerializationUtils.clone(v);
    }

  static class TestPerson extends Person {
    {
      setAge("SD");
    }
  }
}