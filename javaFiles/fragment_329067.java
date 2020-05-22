@Test
public void valueEquals() {
  // Your examples:
  assertTrue(100 == 100l);
  assertTrue(100d == 100l);
  assertNotEquals(100, 100l); // assertEquals autoboxes primitives
  assertNotEquals(new Integer(100), new Long(100));

  // Guava
  assertTrue(Longs.compare(100, 100l) == 0);
  assertTrue(Longs.compare(new Integer(100), new Long(100)) == 0);
  assertTrue(Doubles.compare(100d, 100l) == 0);
  // Illegal, expected compare(int, int)
  //Ints.compare(10, 10l);

  // JDK
  assertTrue(Long.compare(100, 100l) == 0);
  assertTrue(Long.compare(new Integer(100), new Long(100)) == 0);
  assertTrue(Double.compare(100d, 100l) == 0);
  // Illegal, expected compare(int, int)
  //Integer.compare(10, 10l);
  // Illegal, expected compareTo(Long) which cannot be autoboxed from int
  //new Long(100).compareTo(100);
}