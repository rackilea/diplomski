public void addItem(int categoryID, String name, int parentID) {
    Item parentItem = findParent(parentID);
    parentItem.addChild(new Item(categoryID, name, parentID));
}
private Item findParent(int parentID) {
    return rootNode.getItemWithParent(parentID);
}