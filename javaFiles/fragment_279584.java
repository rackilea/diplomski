Table table = new Table();
MyIndexedContainer mic = new MyIndexedContainer();
table.setContainerDataSource(mic);
//...
// check that the container contains the item
if (mic.getUnfilteredItem(item) != null) {
    //...
}