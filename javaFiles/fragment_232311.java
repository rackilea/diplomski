@Rule ExpectedException expectedException = ExpectedException.none();

@Test public void yourTest() {
  // One overload takes a string to test "contains".
  expectedException.expectMessage("foo");

  // The other takes a Hamcrest matcher. startsWith is a Hamcrest core matcher.
  expectedException.expectMessage(startsWith("Bar"));

  // If you include the latest Hamcrest source, you can use the brand-new
  // MatchesPattern matcher, which is the regex solution you're looking for.
  expectedException.expectMessage(new MatchesPattern(
      new Pattern("Baz.+\[[0-9]+\]")));

  systemUnderTest.doExceptionThrowingCode();
}