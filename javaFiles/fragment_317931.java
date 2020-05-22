public InventoryItem seqSearchRec(int sku) {
    int i = seqSearchRecHelper(sku, 0);
    //returns null if the item is not found.
    if (i == -1) return null;
    return inventory.get(i);
}