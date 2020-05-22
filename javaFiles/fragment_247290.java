/**
 * The Class MultiInputClientServerIntegrationTest.
 */
@RunWith(Suite.class)
@SuiteClasses({MultiInputClientServerIntegrationTest.NormalInput.class,
    MultiInputClientServerIntegrationTest.BEECHA01SimulationHashIssue.class})
public class MultiInputClientServerIntegrationTest {

  /**
   * The Class NormalInput.
   */
  @RunWith(Suite.class)
  @SuiteClasses({TestClientServerIntegration.class})
  public class NormalInput {}

  /**
   * The Class BEECHA01SimulationHashIssue.
   */
  // @RunWith(Suite.class)
  @RunWith(InterceptorRunner.class)
  @SuiteClasses({TestClientServerIntegration.class})
  @InterceptorClasses({BEECHA01SimulationHashIssueInterceptor.class})
  public static class BEECHA01SimulationHashIssue extends TestClientServerIntegration {  }

  /**
   * The Class BEECHA01SimulationHashIssueInterceptor.
   */
  public static class BEECHA01SimulationHashIssueInterceptor implements Interceptor {
    static File sim = new File("test\\BEECHA01\\6dof_Block20_FD2_2.zip");
    static String in = "BEECHA01\\config.in";

    /*
     * (non-Javadoc)
     * 
     * @see test.northgrum.globalhawk.simulation.Interceptor#interceptBefore()
     */
    @Override
    public void interceptBefore() {
      if (!TestClientServerIntegration.simulation.equals(sim)
          || !TestClientServerIntegration.inputFile.equals(in)) {
        TestClientServerIntegration.simulation = sim;
        TestClientServerIntegration.inputFile = in;
        System.out.println("Test set up with BEECHA01 Initial Parameters");
      }
    }

    /*
     * (non-Javadoc)
     * 
     * @see test.northgrum.globalhawk.simulation.Interceptor#interceptAfter()
     */
    @Override
    public void interceptAfter() {}
  }
}