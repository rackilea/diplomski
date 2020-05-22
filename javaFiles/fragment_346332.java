// BAD: Unlikely to work
@Test public void yourTest() {
  objectUnderTest.methodUnderTest(
      mock(Handler.class).getClass().getName());
  // ...
}