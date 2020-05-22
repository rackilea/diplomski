private static Map<Integer, Item> prepareIdItemMap(List<Item> items) {
    HashMap<Integer, Item> result = new HashMap<>();

    for (Item eachItem : items) {
        result.put(Integer.valueOf(eachItem.getId()), eachItem);
    }

    return result;
}