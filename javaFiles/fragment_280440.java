public class RunListener {
    public void testRunStarted(Description description) throws Exception {}
    public void testRunFinished(Result result) throws Exception {}
    public void testStarted(Description description) throws Exception {}
    public void testFinished(Description description) throws Exception {}
    public void testFailure(Failure failure) throws Exception {}
    public void testAssumptionFailure(Failure failure) {}
    public void testIgnored(Description description) throws Exception {}
}