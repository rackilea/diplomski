public class MyLegacyClassTest extends TestCase {

  private MockStrategy mockStrategy = new MockStrategy();

  protected void setUp() throws Exception {
    MyLegacyClass.setStrategy(mockStrategy);
  }

  protected void tearDown() throws Exception {
    // TODO, reset original strategy on MyLegacyClass...
  }

  public void testDoSomeLegacyStuff() {
    MyLegacyClass.doSomeLegacyStuff(..);
    assertTrue(..);
  }

  static class MockStrategy implements Strategy{

    public SomeLegacyClass doSomeStuff(SomeOtherLegacyClass legacyObj) {
      // mock behavior however you want, record state however
      // you'd like for test asserts.  Good frameworks like Mockito exist
      // to help create mocks
    }
  }
}