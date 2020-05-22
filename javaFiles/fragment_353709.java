public class PersonTest {

  @Rule
  public ExpectedException exception = ExpectedException.none();

  @Test
  public void testExpectedException() {
    exception.expect(IllegalArgumentException.class);
    exception.expectMessage(containsString("Invalid age"));
    new Person(-1);
  }
}