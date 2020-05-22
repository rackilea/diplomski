try {
  doSomethingThatShouldThrow();
  fail("Should have thrown Exception");
} catch (IllegalArgumentException e) {
  // success
}