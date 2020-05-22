public class MyTest {
  private Obj d;

  @Before
  public void defaultObj() {
    d = new Obj();
  }

  @Test
  public void defaultObj() {
    String name = "";
    assertEquals(name, d.getName());
  }
}