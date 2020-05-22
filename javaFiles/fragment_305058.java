public void testDoSomething(final SomeObject mock)
{
    new ClassToTest().doSomething();

    new Verifications() {{ mock.doSomethingElse(); }};
}