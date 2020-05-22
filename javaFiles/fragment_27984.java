public final class KnownIssueExtension implements TestExecutionExceptionHandler {

    @Override
    public void handleTestExecutionException(final TestExtensionContext context,
                                             final Throwable throwable) 
            throws Exception {

        final Method testMethod = context.getTestMethod().get();
        if (!testMethod.isAnnotationPresent(KnownIssue.class)) {
            throw throwable;
        }
    }
}