public InventoryItem findInventoryItem(int searchPartNumber) {
    for (InventoryItem inventoryItem : items)
        if (inventoryItem.getPartNumber() == searchPartNumber)
            return inventoryItem;
    return null;
}