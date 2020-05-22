@Test
public void exampleTest(@Mocked final Dependency dep) {
    // Record results for methods called on mocked dependencies, if needed:
    new Expectations() {{ dep.doSomething(); result = 123; }}

    new ClassUnderTest().methodUnderTest();

    // Verify another method was called, if desired:
    new Verifications() {{ dep.doSomethingElse(); }}
}