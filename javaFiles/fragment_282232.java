@Rule
public final ExpectedException exception = ExpectedException.none();

@Test
public final void testNullException() throws Exception {
    exception.expect(Exception.class);
    Matcher<String> nullMatcher = new IsNull<>();
    exception.expectMessage(nullMatcher);
    mPackage.getInfo(null);
}