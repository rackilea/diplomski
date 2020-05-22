public final void testPairAsHashMapKey() {

    HashMap<Pair<Integer, Integer>, String> map = new HashMap<Pair<Integer, Integer>, String>();

    Pair<Integer, Integer> p1 = new Pair<Integer, Integer>(0, 0);
    Pair<Integer, Integer> p2 = new Pair<Integer, Integer>(0, 0);
    Pair<Integer, Integer> p3 = new Pair<Integer, Integer>(5, 3);
    Pair<Integer, Integer> p4 = new Pair<Integer, Integer>(3, 5);

    map.put(p1, "foo");
    assertEquals(1, map.size());
    assertEquals("foo", map.get(p1));

    map.put(p2, "new_foo");
    // p2.equals(p1) so map will not grow but value will update
    assertEquals(1, map.size());
    assertEquals("new_foo", map.get(p2));

    map.put(p3, "bar");
    assertEquals(2, map.size());
    assertEquals("bar", map.get(p3));

    map.put(p4, "test");
    assertEquals(3, map.size());
    assertEquals("test", map.get(p4));

}