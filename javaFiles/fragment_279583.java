public class MyIndexedContainer extends IndexedContainer {
    @Override
    public Item getUnfilteredItem(Object itemId) { // make it public
      return super.getUnfilteredItem(itemId);
    }
}