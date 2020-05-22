@Test
public void testCanCreateContextForLambda() {
    ContextFactory factory = new ContextFactory();

    LambdaContext context = factory.forLambda(
            new FakeRequest(),
            new FakeResponse(),
            new FakeLambda()
    );
    assertTrue(context instanceof LambdaContext);
}