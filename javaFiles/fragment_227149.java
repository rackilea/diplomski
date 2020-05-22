@Test
public void test(final SideEffectsClass sideEffects)
{
    List<Object> results = new ClassUnderTest().execute();

    assertEquals(myExpectedResults, results);

    new Verifications() {{
        sideEffects.doSomethingWithSideEffects((List<Object>) any);
    }};
}