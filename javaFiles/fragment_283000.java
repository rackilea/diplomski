public class DoNotRunOnProd extends TestWatcher {
  protected void starting(Description description) { {
    ProdAllowed annotation = description.getAnnotation(ProdAllowed.class);
    String env = CreditCheckSuite.getEnv().trim();
    if ((annotation == null) && !"DEV".equalsIgnoreCase(env) && !"UAT".equalsIgnoreCase(env)) {
      throw new AssumptionViolatedException("Must not run on production.")
    }
  }
}