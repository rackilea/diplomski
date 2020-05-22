private static List<Item> processItemsToParentChildren(List<Item> items) {
    java.util.List<Item> result = new ArrayList<>();

    Map<Integer, Item> idItemMap = prepareIdItemMap(items);

    for (Item eachItem : items) {
        int parentId = eachItem.getParentId();

        if (parentId == 0) {
            result.add(eachItem);
        } else {
            idItemMap.get(Integer.valueOf(parentId)).addChild(eachItem);
        }
    }


        return result;
    }