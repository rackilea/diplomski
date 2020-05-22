@Test
public void testMainWithTestCase0001() {
  String[] params = {"-d", "testcase0001"};
  Main.main(params);
  // usually we'd add some asserts but that's difficult
  // if we test a method that does not return a value...
}

@Test
public void testMainWithTestCase0002() {
  String[] params = {"-d", "testcase0002"};
  Main.main(params);
}