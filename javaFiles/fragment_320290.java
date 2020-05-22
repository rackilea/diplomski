public class LastCall implements VerificationMode {
    public void verify(VerificationData data) {
        List<Invocation> invocations = data.getAllInvocations();
        InvocationMatcher matcher = data.getWanted();
        Invocation invocation = invocations.get(invocations.size() - 1);
        if (!matcher.matches(invocation)) throw new MockitoException("...");
    }
}