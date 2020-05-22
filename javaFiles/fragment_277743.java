try {
  target.someMethodToTest();
  fail("Should have gotten an exception");
} catch (IllegalStateException ise) {
  //expected, it's all good
}