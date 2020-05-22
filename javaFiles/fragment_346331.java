public ReturnType yourMethodUnderTest(String className) {
  Handler handler = createHandler(className);
  // ...
}

/** Package private for testing. */
Handler createHandler(String className) {
  return Class.forName(className).newInstance();
}

@Test public void yourTest() {
  // Manually replace createHandler. You could also use a Mockito spy here.
  ObjectUnderTest objectUnderTest = new ObjectUnderTest() {
    @Override Handler createHandler(String className) {
      return mock(Handler.class);
    }
  }
  // ...
}