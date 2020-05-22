@Test    
public void testWithinRange() {
    // Set up test data (given)
    List<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(2);
    list.add(4);
    list.add(5);
    list.add(7);

    // perform test (when)
    List<Integer> result = Task.withinRange(list, 4, 5);

    // verify results (then)
    assertTrue(result.contains(4));
    assertTrue(result.contains(5));
    assertFalse(result.contains(7));
}