@Test
public void runsSetupWhenRequestedOnFooInitialization()
{
    // Partially mocks the class under test:
    new Expectations(Foo.class) {};

    final Foo foo = new Foo(true);

    // Assuming "setup" is not private (if it is, use Deencapsulation.invoke):
    new Verifications() {{ foo.setup(); }};
}

@Test
public void doesNotRunSetupWhenNotRequestedOnFooInitialization()
{
    new Expectations(Foo.class) {};

    final Foo foo = new Foo(false);

    new Verifications() {{ foo.setup(); times = 0; }};
}