@RunWith(CustomRunner.class)
public class AppTest {

  @Test
  public int testApp() {
    return 0;
  }
}

public class CustomRunner extends JUnit4ClassRunner {

  public CustomRunner(Class<?> klass) throws InitializationError {
    super(klass);
  }

  protected void validate() throws InitializationError {
    // ignore
  }
}