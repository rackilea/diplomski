private Stream<ItemEntity> createItemEntity(Item item) {
    return item.getVarietyList().isEmpty() ?
        Stream.of(loadItemData(item, null)) :
        item.getVarietyList().stream(x -> mapItemVarietyToItemEntity(item, x));
}

private ItemEntity mapItemVarietyToItemEntity(Item item, ItemVariety variety) {
    loadItemData(item, variety);
}