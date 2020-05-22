public InventoryItem deleteInventoryItem(String descriptionIn) {
    for (InventoryItem item : iList)
        if (item.getDescription()
                .toLowerCase()
                .startsWith(descriptionIn.toLowerCase())) {
            iList.remove(item);
            return item;
        }
    }
    return null;
}