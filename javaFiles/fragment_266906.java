public List getItemList() {
    List itemList = getItemsFromDatabase();
    YourItemClass item = new YourItemClass();
    item.setDescription("Select One...");
    itemList.add(item);
    return itemList;
}