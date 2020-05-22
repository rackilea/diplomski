@Test
public void testAddOnceWorks()   {
    XArray<String> b = new XArray<String>();
    b.add("hello");
}
@Test
public void testAddTwiceWorks()   {
    XArray<String> b = new XArray<String>();
    b.add("hello");
    b.add("bye");
}
@Test
public void testInsertOnEmptyWorks()   {
    XArray<String> b = new XArray<String>();
    b.insert(0, "hello");
}
@Test
public void testAddOnceInsertBeforeWorks()   {
    XArray<String> b = new XArray<String>();
    b.add("hello");
    b.insert(0, "hello");
}