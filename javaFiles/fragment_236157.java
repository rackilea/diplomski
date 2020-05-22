public InventoryItem findInventoryItem(String descriptionIn) {
    for (InventoryItem item : iList)
        if (item.getDescription()
                .toLowerCase()
                .startsWith(descriptionIn.toLowerCase())) {
            return item;
        }
    }
    return null;
}

public InventoryItem deleteInventoryItem(String description) {
    InventoryItem item = findInventoryItem(description);
    if (item != null)
        iList.remove(item);
    return item;
}