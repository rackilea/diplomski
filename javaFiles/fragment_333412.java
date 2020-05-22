private HtmlInputHidden itemId = new HtmlInputHidden();
private Item item = new Item();

public void editItem() { // Action method when selecting an item for edit.        
    itemId.setValue(item.getId());
}

public void saveItem() { // Action method when saving edited item.
    item.setId((Integer) itemId.getValue());
}