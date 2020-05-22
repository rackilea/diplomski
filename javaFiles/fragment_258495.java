@Test
public void testReverseList() {
    LinkedList someList = new LinkedList();
    myList.insert(1, 1);
    myList.insert(2, 2);
    myList.insert(3, 3);

    LinkedList expectedList = new LinkedList();
    // You'll probably want to check these lines in order to ensure I'm using it the right way
    expectedList.insert(3, 1);
    expectedList.insert(2, 2);
    expectedList.insert(1, 3);

    for (int i = 0; i < expectedList.size(); i++)
        assertEquals("Checking item with index " + i, myList.get(i), expectedList.get(i));
    assertEquals(myList.size(), expectedList.size());

    // Or even better, implement LinkedList.equals() so you can use
    assertEquals("Check reverseList", myList, expectedList);    
}