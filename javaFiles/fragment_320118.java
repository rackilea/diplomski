public class EnvironmentVariablesTest {

  @Rule
  public final EnvironmentVariables environmentVariables = new EnvironmentVariables();

  @Test
  public void setEnvironmentVariable() {
    environmentVariables.set("name", "value");
    assertEquals("value", System.getenv("name"));
  }
}