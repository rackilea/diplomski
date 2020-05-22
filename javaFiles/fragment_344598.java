@GwtIncompatible("NullPointerTester")
public void testNullPointers() {
  NullPointerTester tester = new NullPointerTester();
  tester.testAllPublicStaticMethods(Splitter.class);
  tester.testAllPublicInstanceMethods(Splitter.on(','));
  tester.testAllPublicInstanceMethods(Splitter.on(',').trimResults());
}