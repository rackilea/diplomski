public void testMyException() {
  try {
    objectUnderTest.myMethod(EVIL_ARGUMENT);
    fail("myMethod did not throw an Exception!");
  } catch (MyException e) {
    // ok!
    // check for properties of exception here, if desired
  }
}