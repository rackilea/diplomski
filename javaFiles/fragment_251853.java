public static class ContainerFactory {
  public static <T extends Item>BaseContainer<T> getContainer(Item item) {
     return (BaseContainer<T>) new GenericTest().new Document();
  }
}

@Test
public void theTest(){
    Item item = new WordItem();
    BaseContainer<Item> container = ContainerFactory.getContainer(item);
    String str = container.getItemProperty(item);
}