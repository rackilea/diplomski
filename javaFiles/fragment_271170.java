public static List<List<Item>> partitionList(ItemCollection<QueryOutcome> items) {
    final int partitionSize = 20;
    List<List<Item>> partitioned = new LinkedList<List<Item>>();
    List<Item> itemList = new ArrayList<Item>();
    for(Item item : items) {
        itemList.add(item);
        if (itemList.size() == partitionSize) {
            partitioned.add(itemList);
            itemList = new ArrayList<Item>();
        }
    }

    if (itemList.size() != 0) {
        partitioned.add(itemList);
    }

    return partitioned;
}