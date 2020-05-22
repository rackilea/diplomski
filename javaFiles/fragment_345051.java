for (Iterator<ItemDto> iterator = itemDtos.iterator(); iterator.hasNext()) {
    ItemDto itemDto = iterator.next();
    if (itemDto.getIsRemoved()) {
        deleteItemIds.add(itemDto.getId());
        iterator.remove(); 
    }
}