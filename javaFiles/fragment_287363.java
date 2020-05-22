@Test
public void multiplicationOfZeroIntegersShouldReturnZero() {
  MyClass tester = new MyClass(); // MyClass is tested

  // assert statements
  assertEquals(0, tester.multiply(10, 0), "10 x 0 must be 0");
  assertEquals(0, tester.multiply(0, 10), "0 x 10 must be 0");
  assertEquals(0, tester.multiply(0, 0), "0 x 0 must be 0");

  assertEquals(10, tester.multiply(10, 1), "10 x 1 must be 10");
}