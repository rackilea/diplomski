class DisallowUppercaseLetterAtBeginningTest {

    @Test
    void should_succeed_if_method_name_starts_with_lower_case() {
        TestExecutionSummary summary = runTestMethod(MyTest.class, "validTest");

        assertThat(summary.getTestsSucceededCount()).isEqualTo(1);
    }

    @Test
    void should_fail_if_method_name_starts_with_upper_case() {
        TestExecutionSummary summary = runTestMethod(MyTest.class, "InvalidTest");

        assertThat(summary.getTestsFailedCount()).isEqualTo(1);
        assertThat(summary.getFailures().get(0).getException())
                .isInstanceOf(RuntimeException.class)
                .hasMessage("test method names should start with lowercase.");
    }

    private TestExecutionSummary runTestMethod(Class<?> testClass, String methodName) {
        SummaryGeneratingListener listener = new SummaryGeneratingListener();

        LauncherDiscoveryRequest request = request().selectors(selectMethod(testClass, methodName)).build();
        LauncherFactory.create().execute(request, listener);

        return listener.getSummary();
    }

    @ExtendWith(DisallowUppercaseLetterAtBeginning.class)
    static class MyTest {

        @Test
        void validTest() {
        }

        @Test
        void InvalidTest() {
            fail("test should have failed before");
        }
    }
}