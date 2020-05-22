@Test
public void doStuff() throws ClassNotFoundException {

    Index mockIndex;
    ItemCollection<String> mockItemCollection;
    Item mockItem = new Item().with("attributeName", "Hello World");

    mockItemCollection = EasyMock.createMock(ItemCollection.class);

    Class<?> itemSupportClasss = Class.forName("com.amazonaws.services.dynamodbv2.document.internal.IteratorSupport");
    Iterator<Item> mockIterator = (Iterator<Item>) EasyMock.createMock(itemSupportClasss);

    EasyMock.expect(((Iterable)mockItemCollection).iterator()).andReturn(mockIterator);     
    EasyMock.expect(mockIterator.hasNext()).andReturn(true);
    EasyMock.expect(mockIterator.next()).andReturn(mockItem);
    EasyMock.replay(mockItemCollection, mockIterator);

    /* Need to cast item collection into an Iterable<T> in 
       class under test, prior to calling iterator. */
    Iterator<Item> Y = ((Iterable)mockItemCollection).iterator();
    Assert.assertSame(mockItem, Y.next());

}