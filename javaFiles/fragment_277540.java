@Test
public void doWhenItemIsModified (Item item) {
   Item copyItem = item.deepCopy(item);
   instanceUnderTest.do(item);
   Assert.assertNotEquals(copyItem.getMyField(), item.getMyField())
   ... // assert other fields...
}