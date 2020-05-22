Map<Long, Long> reversed = new HashMap<>();
Iterator<Map.Entry<Long, Item>> iterator = itemMap.entrySet().iterator();
while (iterator.hasNext()) {
    Map.Entry<Long, Item> pair = iterator.next();
    Long itemKey = reversed.get(pair.getValue().id);
    if (itemKey != null) {
        Item item = itemMap.get(itemKey);
        item.merge(pair.getValue());
        iterator.remove();
    } else {
        reversed.put(pair.getValue().id, pair.getKey());
    }
}