@Test
public void shouldTestNGIgnoreAssertsAfterExceptionThrown() {
  String iAmNull = null;
  boolean hasNpe = false;
  try {
    int length = iAmNull.length();
  } catch(NullPointerException npe) {
    hasNpe = true;
  }
  assertTrue(hasNpe);
  assertEquals(0, 1);
}